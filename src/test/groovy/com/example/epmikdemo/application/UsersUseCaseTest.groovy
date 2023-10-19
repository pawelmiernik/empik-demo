package com.example.epmikdemo.application

import com.example.epmikdemo.application.helper.UserResponseDTOHelper
import com.example.epmikdemo.domain.user.helper.UserHelper
import com.example.epmikdemo.domain.user.helper.UserRequestRepositoryHelper
import com.example.epmikdemo.domain.user.port.UserRepositoryPort
import com.example.epmikdemo.openapi.model.UserResponseDTO
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.*
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UsersUseCaseTest extends Specification {

    static final String USERS_URL = "http://localhost:%d/empikdemo/api/users?login={login}"
    static final String LOGIN = "alan"

    @LocalServerPort
    int port

    @Autowired
    UserRequestRepositoryHelper userRequestRepositoryHelper

    @Autowired
    RestTemplate restTemplate

    @SpringBean
    UserRepositoryPort userRepositoryPort = Mock()

    def cleanup() {
        userRequestRepositoryHelper.cleanup()
    }

    def "should get user"() {
        given:
            def user = UserHelper.userEntity(login: LOGIN)
        when:
            ResponseEntity<UserResponseDTO> response = restTemplate.exchange(String.format(USERS_URL, port), HttpMethod.GET, new HttpEntity<Void>(null, new HttpHeaders()), UserResponseDTO.class, LOGIN)
        then:
            1 * userRepositoryPort.getUserByLogin(LOGIN) >> Optional.ofNullable(user)
            response.statusCode == HttpStatus.OK
            UserResponseDTOHelper.compare(response.getBody(), user)
            userRequestRepositoryHelper.findUser(LOGIN).requestCount == 1
    }

    def "should get user twice"() {
        given:
            def user = UserHelper.userEntity(login: LOGIN)
        when:
            restTemplate.exchange(String.format(USERS_URL, port), HttpMethod.GET, new HttpEntity<Void>(null, new HttpHeaders()), UserResponseDTO.class, LOGIN)
            restTemplate.exchange(String.format(USERS_URL, port), HttpMethod.GET, new HttpEntity<Void>(null, new HttpHeaders()), UserResponseDTO.class, LOGIN)
        then:
            2 * userRepositoryPort.getUserByLogin(LOGIN) >> Optional.ofNullable(user)
            userRequestRepositoryHelper.findUser(LOGIN).requestCount == 2
    }

    def "should return 404 when not found user"() {
        when:
            try {
                restTemplate.exchange(String.format(USERS_URL, port), HttpMethod.GET, new HttpEntity<Void>(null, new HttpHeaders()), UserResponseDTO.class, LOGIN)
            } catch (HttpClientErrorException ex) {
                ex.statusCode == HttpStatus.NOT_FOUND
            }
        then:
            1 * userRepositoryPort.getUserByLogin(LOGIN) >> Optional.empty()
            userRequestRepositoryHelper.findUser(LOGIN).requestCount == 1

    }

    def "should throw exception when not found user"() {
        when:
            restTemplate.exchange(String.format(USERS_URL, port), HttpMethod.GET, new HttpEntity<Void>(null, new HttpHeaders()), UserResponseDTO.class, LOGIN)

        then:
            1 * userRepositoryPort.getUserByLogin(LOGIN) >> Optional.empty()
            thrown(HttpClientErrorException)
            userRequestRepositoryHelper.findUser(LOGIN).requestCount == 1
    }


}
