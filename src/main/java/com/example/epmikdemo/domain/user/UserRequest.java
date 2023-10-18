package com.example.epmikdemo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String login;
  private Integer requestCount;
}
