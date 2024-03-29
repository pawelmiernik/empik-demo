package com.example.epmikdemo.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @JsonProperty("login")
  private String login;
  @JsonProperty("id")
  private Integer id;
  @JsonProperty("node_id")
  private String nodeId;
  @JsonProperty("avatar_url")
  private String avatarUrl;
  @JsonProperty("gravatar_id")
  private String gravatarId;
  @JsonProperty("url")
  private String url;
  @JsonProperty("html_url")
  private String htmlUrl;
  @JsonProperty("followers_url")
  private String followersUrl;
  @JsonProperty("following_url")
  private String followingUrl;
  @JsonProperty("gists_url")
  private String gistsUrl;
  @JsonProperty("starred_url")
  private String starredUrl;
  @JsonProperty("subscriptions_url")
  private String subscriptionsUrl;
  @JsonProperty("organizations_url")
  private String organizationsUrl;
  @JsonProperty("repos_url")
  private String reposUrl;
  @JsonProperty("events_url")
  private String eventsUrl;
  @JsonProperty("received_events_url")
  private String receivedEventsUrl;
  @JsonProperty("type")
  private String type;
  @JsonProperty("site_admin")
  private boolean siteAdmin;
  @JsonProperty("name")
  private String name;
  @JsonProperty("company")
  private String company;
  @JsonProperty("blog")
  private String blog;
  @JsonProperty("location")
  private String location;
  @JsonProperty("email")
  private String email;
  @JsonProperty("hireable")
  private String hireable;
  @JsonProperty("bio")
  private String bio;
  @JsonProperty("twitter_username")
  private String twitterUsername;
  @JsonProperty("public_repos")
  private Integer publicRepos;
  @JsonProperty("public_gists")
  private Integer publicGists;
  @JsonProperty("followers")
  private Integer followers;
  @JsonProperty("following")
  private Integer following;
  @JsonProperty("created_at")
  private LocalDateTime createdAt;
  @JsonProperty("updated_at")
  private LocalDateTime updatedAt;
}
