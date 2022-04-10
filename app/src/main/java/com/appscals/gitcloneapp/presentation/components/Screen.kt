package com.appscals.gitcloneapp.presentation.components

sealed class Screen(val route: String) {
    object UserListScreen: Screen("user_list_screen")
    object UserDetailScreen: Screen("user_detail_screen")
}
