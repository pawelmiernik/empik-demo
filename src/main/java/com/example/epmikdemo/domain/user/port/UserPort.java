package com.example.epmikdemo.domain.user.port;

import com.example.epmikdemo.domain.user.User;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UserPort {
  Optional<User> getUserByLogin(@NotNull String login);

  void saveUserRequest(@NotNull String login);
}
