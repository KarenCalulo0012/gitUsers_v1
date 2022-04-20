package com.appscals.gitcloneapp.data.remote

import com.appscals.gitcloneapp.data.remote.dto.UserDto
import com.appscals.gitcloneapp.data.remote.dto.UsersDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("users")
    suspend fun getAllUsers(): List<UsersDto>

    @GET("users/{username}")
    suspend fun getUserInfo(@Path("username") userName: String): UserDto
}