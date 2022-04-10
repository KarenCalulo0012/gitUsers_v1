package com.appscals.gitcloneapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appscals.gitcloneapp.R
import com.appscals.gitcloneapp.domain.usecase.GetUsersUseCase
import com.appscals.gitcloneapp.presentation.state.UserListState
import com.appscals.gitcloneapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UsersViewModel
@Inject constructor(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {

    private val _state = mutableStateOf(UserListState())
    val state: State<UserListState> = _state

    init {
        getUserList()
    }

    private fun getUserList() {
        getUsersUseCase().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = UserListState(users = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        UserListState(error = it.message ?: R.string.http_Error.toString())
                }
                is Resource.Loading -> {
                    _state.value = UserListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}