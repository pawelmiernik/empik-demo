package com.example.epmikdemo.domain.user

import com.example.epmikdemo.domain.user.helper.UserAdepterHelper
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
    UserAdepterHelper userAdepterHelper

    def cleanup() {
        userAdepterHelper.cleanup()
    }



    def "should save user request"() {
        given:
            userPort.saveUserRequest(LOGIN)
        when:
            UserRequest actual = userAdepterHelper.findUser(LOGIN)
        then:
            actual.login.equals(LOGIN)
            actual.requestCount == 1
    }

    def "should save two user request"() {
        given:
            userPort.saveUserRequest(LOGIN)
            userPort.saveUserRequest(LOGIN)
        when:
            UserRequest actual = userAdepterHelper.findUser(LOGIN)
        then:
            actual.login.equals(LOGIN)
            actual.requestCount == 2
    }
}
