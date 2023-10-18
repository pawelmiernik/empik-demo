package com.example.epmikdemo.domain.user

import com.example.epmikdemo.domain.user.helper.UserRequestRepositoryHelper
import com.example.epmikdemo.domain.user.port.UserPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UserAdapterTest extends Specification {

    static final String LOGIN = "alan"

    @Autowired
    UserPort userPort

    @Autowired
    UserRequestRepositoryHelper userRequestRepositoryHelper

    def cleanup() {
        userRequestRepositoryHelper.cleanup()
    }


    def "should save user request"() {
        given:
            userPort.saveUserRequest(LOGIN)
        expect:
            UserRequest actual = userRequestRepositoryHelper.findUser(LOGIN)
            actual.login == LOGIN
            actual.requestCount == 1
    }

    def "should save two user request"() {
        given:
            userPort.saveUserRequest(LOGIN)
            userPort.saveUserRequest(LOGIN)
        expect:
            UserRequest actual = userRequestRepositoryHelper.findUser(LOGIN)
            actual.login == LOGIN
            actual.requestCount == 2
    }
}
