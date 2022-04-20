package com.appscals.gitcloneapp.domain.model

data class User(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val htmlUrl: String,
    val followersUrl: String,
    val followingUrl: String,
    val reposUrl: String,
    val type: String,
    val name: String,
    val company: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val twitterUsername: String?,
    val following: Int,
    val followers: Int,
    val publicRepos: Int,
    val publicGists: Int,

    )