package com.example.epmikdemo.application;

import com.example.epmikdemo.domain.user.port.UserPort;
import com.example.epmikdemo.openapi.api.UsersApiDelegate;
import com.example.epmikdemo.openapi.model.UserResponseDTO;
import com.example.epmikdemo.shared.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@AllArgsConstructor
@Validated
public class UsersUseCase implements UsersApiDelegate {

  private final UserDTOMapper mapper;
  private final UserPort service;

  @Override
  public ResponseEntity<UserResponseDTO> getUser(String login) {
    service.saveUserRequest(login);
    return new ResponseEntity<>(
        mapper.map(service.getUserByLogin(login).orElseThrow(() -> new UserNotFoundException(String.format("User not found for login: {%s}", login)))),
        HttpStatus.OK);
  }
}
