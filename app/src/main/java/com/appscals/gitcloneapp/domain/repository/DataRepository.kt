package com.appscals.gitcloneapp.domain.repository

import com.appscals.gitcloneapp.data.remote.dto.UserDto
import com.appscals.gitcloneapp.data.remote.dto.UsersDto

interface DataRepository {

    suspend fun getUsers(): List<UsersDto>

    suspend fun getUserInfo(userName: String): UserDto
}