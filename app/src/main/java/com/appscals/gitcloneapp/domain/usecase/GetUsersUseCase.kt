package com.appscals.gitcloneapp.domain.usecase

import com.appscals.gitcloneapp.R
import com.appscals.gitcloneapp.data.remote.dto.toUsers
import com.appscals.gitcloneapp.domain.model.Users
import com.appscals.gitcloneapp.domain.repository.DataRepository
import com.appscals.gitcloneapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsersUseCase
@Inject constructor(private val repository: DataRepository)
{
    operator fun invoke(): Flow<Resource<List<Users>>> = flow {
        try {
            emit(Resource.Loading<List<Users>>())
            val users = repository.getUsers().map { it.toUsers() }
            emit(Resource.Success<List<Users>>(users))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Users>>(e.localizedMessage ?: R.string.http_Error.toString()))
        } catch (e:IOException) {
            emit(Resource.Error<List<Users>>(R.string.conn_Error.toString()))
        }
    }
}