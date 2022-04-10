package com.appscals.gitcloneapp.domain.repository

import com.appscals.gitcloneapp.data.remote.dto.UsersDto

interface DataRepository {

    suspend fun getUsers(): List<UsersDto>
}