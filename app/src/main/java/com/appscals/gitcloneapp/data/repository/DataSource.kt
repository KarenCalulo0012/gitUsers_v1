package com.appscals.gitcloneapp.data.repository

import com.appscals.gitcloneapp.data.remote.ApiInterface
import com.appscals.gitcloneapp.data.remote.dto.UsersDto
import com.appscals.gitcloneapp.domain.repository.DataRepository
import javax.inject.Inject

class DataSource
    @Inject constructor(private val api: ApiInterface) : DataRepository
{
    override suspend fun getUsers(): List<UsersDto> {
        return api.getAllUsers()
    }

}