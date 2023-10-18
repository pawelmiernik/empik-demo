package com.example.epmikdemo.infrastructure.user.h2;

import com.example.epmikdemo.domain.user.UserRequest;
import com.example.epmikdemo.domain.user.port.UserRequestRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Repository
@AllArgsConstructor
@Validated
class UserRequestRepositoryAdapter implements UserRequestRepositoryPort {

  private final UserRequestRepository repository;

  @Override
  public Optional<UserRequest> findUserRequestByLogin(String login) {
    return repository.findUserRequestByLogin(login);
  }

  @Override
  public void save(UserRequest userRequest) {
    repository.save(userRequest);
  }

  @Override
  public void clear() {
    repository.deleteAll();
  }
}
