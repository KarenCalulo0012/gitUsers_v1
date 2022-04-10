package com.appscals.gitcloneapp.domain.model

import com.google.gson.annotations.SerializedName

data class Users(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val url: String,
    val htmlUrl: String,
    val type: String
)
