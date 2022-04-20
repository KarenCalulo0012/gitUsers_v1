package com.appscals.gitcloneapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appscals.gitcloneapp.domain.model.User
import com.appscals.gitcloneapp.domain.usecase.GetUserInfoUseCase
import com.appscals.gitcloneapp.utils.Constants
import com.appscals.gitcloneapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel
@Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(UserInfoState())
    val state: State<UserInfoState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_USER_NAME)?.let {
            getUser(it)
        }
    }

    private fun getUser(userName: String) {
        getUserInfoUseCase(userName).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = UserInfoState(user = it.data)
                }
                is Resource.Error -> {
                    _state.value =
                        UserInfoState(error = it.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = UserInfoState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class UserInfoState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String = ""
)