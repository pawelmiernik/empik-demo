package com.example.epmikdemo.application.helper

import com.example.epmikdemo.domain.user.User
import com.example.epmikdemo.openapi.model.UserResponseDTO

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class UserResponseDTOHelper {
    private static Map defaultUserResponseDTOEntityArgs() {
        [
            login       : "octocat",
            type        : "User",
            name        : "The Octocat",
            avatarUrl   : "https://avatars.githubusercontent.com/u/583231?v=4",
            createdAt   : "2011-01-25T18:44:36Z",
            calculations: 5
        ]
    }

    static UserResponseDTO userResponseDTOEntity(Map customArgs = [:]) {
        Map args = defaultUserResponseDTOEntityArgs()
        args << customArgs

        def userResponseDTO = new UserResponseDTO()
        userResponseDTO.setId(args.id as Integer)
        userResponseDTO.setLogin(args.login as String)
        userResponseDTO.setName(args.name as String)
        userResponseDTO.setType(args.type as String)
        userResponseDTO.setAvatarUrl(args.avatarUrl as String)
        userResponseDTO.setCreatedAt(LocalDateTime.parse(args.createdAt, DateTimeFormatter.ISO_DATE_TIME) as LocalDateTime)
        userResponseDTO.setCalculations(args.calculations as Float)
        userResponseDTO
    }

    static boolean compare(UserResponseDTO userResponseDTO, User user) {

        def calculations = (float)6 / user.followers * (2 + user.publicRepos)
        assert userResponseDTO.id
        assert userResponseDTO.login
        assert userResponseDTO.name
        assert userResponseDTO.type
        assert userResponseDTO.avatarUrl
        assert userResponseDTO.createdAt
        assert userResponseDTO.calculations
        assert userResponseDTO.id == user.id
        assert userResponseDTO.login == user.login
        assert userResponseDTO.name == user.name
        assert userResponseDTO.type == user.type
        assert userResponseDTO.avatarUrl == user.avatarUrl
        assert userResponseDTO.createdAt == user.createdAt
        assert userResponseDTO.calculations == calculations.toFloat()
        true
    }
}
