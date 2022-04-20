package com.appscals.gitcloneapp.domain.usecase

import com.appscals.gitcloneapp.R
import com.appscals.gitcloneapp.data.remote.dto.toUserDetail
import com.appscals.gitcloneapp.domain.model.User
import com.appscals.gitcloneapp.domain.repository.DataRepository
import com.appscals.gitcloneapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserInfoUseCase
@Inject constructor(private val repository: DataRepository) {
    operator fun invoke(userName: String): Flow<Resource<User>> = flow {
        try {
            emit(Resource.Loading<User>())
            val user = repository.getUserInfo(userName).toUserDetail()
            emit(Resource.Success<User>(user))
        } catch (e: HttpException) {
            emit(Resource.Error<User>(e.localizedMessage ?: R.string.http_Error.toString()))
        } catch (e: IOException) {
            emit(Resource.Error<User>(R.string.conn_Error.toString()))
        }
    }
}