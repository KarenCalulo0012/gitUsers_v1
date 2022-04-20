package com.appscals.gitcloneapp.data.remote.dto


import com.appscals.gitcloneapp.domain.model.User
import com.google.gson.annotations.SerializedName

data class UserDto(
    val login: String,
    val id: Int,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("gravatar_id")
    val gravatarId: String?,
    val url: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("followers_url")
    val followersUrl: String,
    @SerializedName("following_url")
    val followingUrl: String,
    @SerializedName("gists_url")
    val gistsUrl: String,
    @SerializedName("starred_url")
    val starredUrl: String,
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String,
    @SerializedName("organizations_url")
    val organizationsUrl: String,
    @SerializedName("repos_url")
    val reposUrl: String,
    @SerializedName("events_url")
    val eventsUrl: String,
    @SerializedName("received_events_url")
    val receivedEventsUrl: String,
    val type: String,
    @SerializedName("site_admin")
    val siteAdmin: Boolean,
    val name: String,
    val company: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val hireable: Any?,
    val bio: Any?,
    @SerializedName("twitter_username")
    val twitterUsername: String?,
    @SerializedName("public_repos")
    val publicRepos: Int,
    @SerializedName("public_gists")
    val publicGists: Int,
    val followers: Int,
    val following: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)

fun UserDto.toUserDetail(): User {
    return User(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        htmlUrl = htmlUrl,
        followersUrl = followersUrl,
        followingUrl = followingUrl,
        reposUrl = reposUrl,
        type = type,
        name = name,
        company = company,
        blog = blog,
        location = location,
        email = email,
        twitterUsername = twitterUsername,
        followers = followers,
        following = following,
        publicGists = publicGists,
        publicRepos = publicRepos
    )
}

