package com.example.epmikdemo.application


import com.example.epmikdemo.domain.user.helper.UserAdepterHelper
import com.example.epmikdemo.domain.user.helper.UserHelper
import com.example.epmikdemo.domain.user.port.UserRepositoryPort
import com.example.epmikdemo.openapi.model.UserResponseDTO
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.*
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
    UserAdepterHelper userAdepterHelper

    @Autowired
    RestTemplate restTemplate

    @SpringBean
    UserRepositoryPort userRepositoryPort = Mock()

    def cleanup() {
        userAdepterHelper.cleanup()
    }

    def "should get agent"() {
        when:
            ResponseEntity<UserResponseDTO> response = restTemplate.exchange(String.format(USERS_URL, port), HttpMethod.GET, new HttpEntity<Void>(null, new HttpHeaders()), UserResponseDTO.class, LOGIN)
        then:
            1 * userRepositoryPort.getUserByLogin(LOGIN) >> Optional.ofNullable(UserHelper.userEntity(login: LOGIN))
            response.statusCode == HttpStatus.OK
            response.getBody().login == LOGIN
            response.getBody().calculations != null
    }


}
