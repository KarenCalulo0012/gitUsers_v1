package com.appscals.gitcloneapp.presentation.state

import com.appscals.gitcloneapp.domain.model.Users

data class UserListState(
    val isLoading: Boolean = false,
    val users: List<Users> = emptyList(),
    val error: String = ""
)
