package com.example.epmikdemo.infrastructure.user.rest;

import com.example.epmikdemo.domain.user.User;
import com.example.epmikdemo.domain.user.port.UserRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Validated
class UserRepositoryAdapter implements UserRepositoryPort {

  private final RestTemplate restTemplate;
  private static final String GET_USER = "https://api.github.com/users/%s";

  @Override
  public Optional<User> getUserByLogin(@NotNull String login) {

    try {
      return Optional.ofNullable(restTemplate.getForObject(String.format(GET_USER, login), User.class));
    }
    catch (HttpClientErrorException | HttpServerErrorException ex) {
      if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
        return Optional.empty();
      }
    }
    return Optional.empty();
  }

}
