package com.example.epmikdemo.domain.user;

import com.example.epmikdemo.domain.user.port.UserPort;
import com.example.epmikdemo.domain.user.port.UserRepositoryPort;
import com.example.epmikdemo.domain.user.port.UserRequestRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
class UserAdapter implements UserPort {

  private final UserRepositoryPort repository;
  private final UserRequestRepositoryPort userRequestRepositoryPort;

  @Override
  public Optional<User> getUserByLogin(@NotNull String login) {
    return repository.getUserByLogin(login);
  }

  @Override
  public void saveUserRequest(@NotNull String login) {
    var user = userRequestRepositoryPort.findUserRequestByLogin(login);
    if (user.isEmpty()) {
      userRequestRepositoryPort.save(UserRequest.builder()
          .login(login)
          .requestCount(1)
          .build());
    }
    else {
      userRequestRepositoryPort.save(UserRequest.builder()
          .id(user.get().getId())
          .login(login)
          .requestCount(user.get().getRequestCount() + 1)
          .build());
    }

  }
}
