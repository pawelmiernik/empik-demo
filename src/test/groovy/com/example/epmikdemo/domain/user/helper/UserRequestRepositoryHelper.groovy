package com.example.epmikdemo.domain.user.helper

import com.example.epmikdemo.domain.user.UserRequest
import com.example.epmikdemo.domain.user.port.UserRequestRepositoryPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserRequestRepositoryHelper {

    @Autowired
    UserRequestRepositoryPort userRequestRepositoryPort

    def cleanup() {
        userRequestRepositoryPort.clear()
    }

    UserRequest findUser(String login) {
        userRequestRepositoryPort.findUserRequestByLogin(login).orElse(null)
    }
}
