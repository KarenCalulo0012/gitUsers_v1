package com.appscals.gitcloneapp.data.remote

import com.appscals.gitcloneapp.data.remote.dto.UsersDto
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    suspend fun getAllUsers(): List<UsersDto>
}