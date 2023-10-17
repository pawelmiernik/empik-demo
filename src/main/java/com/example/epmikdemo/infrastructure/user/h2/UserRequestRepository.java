package com.example.epmikdemo.infrastructure.user.h2;

import com.example.epmikdemo.domain.user.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserRequestRepository extends JpaRepository<UserRequest, Long> {
  Optional<UserRequest> findUserRequestByLogin(String login);
}
