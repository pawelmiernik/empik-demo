package com.example.epmikdemo.domain.user.helper

import com.example.epmikdemo.domain.user.User

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class UserHelper {

    private static Map defaultUserEntityArgs() {
        [
            login            : "octocat",
            id               : 583231,
            nodeId           : "MDQ6VXNlcjU4MzIzMQ==",
            avatarUrl        : "https://avatars.githubusercontent.com/u/583231?v=4",
            gravatarId       : "",
            url              : "https://api.github.com/users/octocat",
            htmlUrl          : "https://github.com/octocat",
            followersUrl     : "https://api.github.com/users/octocat/followers",
            followingUrl     : "https://api.github.com/users/octocat/following{/other_user}",
            gistsUrl         : "https://api.github.com/users/octocat/gists{/gist_id}",
            starredUrl       : "https://api.github.com/users/octocat/starred{/owner}{/repo}",
            subscriptionsUrl : "https://api.github.com/users/octocat/subscriptions",
            organizationsUrl : "https://api.github.com/users/octocat/orgs",
            reposUrl         : "https://api.github.com/users/octocat/repos",
            eventsUrl        : "https://api.github.com/users/octocat/events{/privacy}",
            receivedEventsUrl: "https://api.github.com/users/octocat/received_events",
            type             : "User",
            siteAdmin        : false,
            name             : "The Octocat",
            company          : "@github",
            blog             : "https://github.blog",
            location         : "San Francisco",
            email            : null,
            hireable         : null,
            bio              : null,
            twitterUsername  : null,
            publicRepos      : 8,
            publicGists      : 8,
            followers        : 10738,
            following        : 9,
            createdAt        : "2011-01-25T18:44:36Z",
            updatedAt        : "2023-09-22T11:25:21Z"
        ]
    }

    static User userEntity(Map customArgs = [:]) {
        Map args = defaultUserEntityArgs()
        args << customArgs

        def user = User.builder()
            .login(args.login as String)
            .id(args.id as Integer)
            .nodeId(args.nodeId as String)
            .avatarUrl(args.avatarUrl as String)
            .gravatarId(args.gravatarId as String)
            .url(args.url as String)
            .htmlUrl(args.htmlUrl as String)
            .followersUrl(args.followersUrl as String)
            .followingUrl(args.followingUrl as String)
            .gistsUrl(args.gistsUrl as String)
            .starredUrl(args.starredUrl as String)
            .subscriptionsUrl(args.subscriptionsUrl as String)
            .organizationsUrl(args.organizationsUrl as String)
            .reposUrl(args.reposUrl as String)
            .eventsUrl(args.eventsUrl as String)
            .receivedEventsUrl(args.receivedEventsUrl as String)
            .type(args.type as String)
            .siteAdmin(args.siteAdmin as Boolean)
            .name(args.name as String)
            .company(args.company as String)
            .blog(args.blog as String)
            .location(args.location as String)
            .email(args.email as String)
            .hireable(args.hireable as String)
            .bio(args.bio as String)
            .twitterUsername(args.twitterUsername as String)
            .publicRepos(args.publicRepos as Integer)
            .publicGists(args.publicGists as Integer)
            .followers(args.followers as Integer)
            .following(args.following as Integer)
            .createdAt(LocalDateTime.parse(args.createdAt, DateTimeFormatter.ISO_DATE_TIME) as LocalDateTime)
            .updatedAt(LocalDateTime.parse(args.updatedAt, DateTimeFormatter.ISO_DATE_TIME) as LocalDateTime)
            .build()

        user
    }
}
