package com.example.epmikdemo.application;

import com.example.epmikdemo.domain.user.User;
import com.example.epmikdemo.openapi.model.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
interface UserDTOMapper {

  @Mapping(target = "createdAt", source = "createdAt")
  @Mapping(target = "avatarUrl", source = "avatarUrl")
  @Mapping(target = "calculations", source = ".", qualifiedByName = "calculationsMap")
  UserResponseDTO map(User user);

  @Named("calculationsMap")
  public static Float calculationsMap(User user) {
    if (user.getFollowers() > 0) {
      return (float)6 / user.getFollowers() * (2 + user.getPublicRepos());
    }
    return (float)0;
  }
}
