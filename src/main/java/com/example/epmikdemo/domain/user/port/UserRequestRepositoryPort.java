package com.example.epmikdemo.domain.user.port;

import com.example.epmikdemo.domain.user.UserRequest;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UserRequestRepositoryPort {
  Optional<UserRequest> findUserRequestByLogin(@NotNull String login);

  void save(@NotNull UserRequest userRequest);

  void clear();
}
