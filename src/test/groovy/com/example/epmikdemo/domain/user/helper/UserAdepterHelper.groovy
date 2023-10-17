package com.example.epmikdemo.domain.user.helper

import com.example.epmikdemo.domain.user.UserRequest
import com.example.epmikdemo.domain.user.port.UserRequestRepositoryPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserAdepterHelper {

    @Autowired
    UserRequestRepositoryPort userRequestRepositoryPort

    def cleanup() {
        userRequestRepositoryPort.clear()
    }

    UserRequest findUser(String login) {
        userRequestRepositoryPort.findUserRequestByLogin(login).orElse(null)
    }



//    private static Map defaultUserRequestEntityArgs(Map customArgs = [:]) {
//        [
//            login   : "ala"
//        ]
//    }
//
//    static UserRequest userRequestEntity(Map customArgs = [:]) {
//        Map args = defaultMorfologikReqDTOEntityArgs(customArgs)
//        args << customArgs
//
//        def entity = MorfologikReqDTO.builder()
//            .content(args.content as String)
//            .build()
//
//        entity
//    }
}
