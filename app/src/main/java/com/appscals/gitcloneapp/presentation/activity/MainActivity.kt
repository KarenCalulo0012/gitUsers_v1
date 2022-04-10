package com.appscals.gitcloneapp.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appscals.gitcloneapp.presentation.components.Screen
import com.appscals.gitcloneapp.presentation.components.UserDetailScreen
import com.appscals.gitcloneapp.presentation.components.UserListScreen
import com.appscals.gitcloneapp.ui.theme.JetpackComposeMVVMRetrofitAndRecyclerviewTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMVVMRetrofitAndRecyclerviewTheme() {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.UserListScreen.route
                    ) {
                        composable(route = Screen.UserListScreen.route) {
                            UserListScreen(navController)
                        }
                        composable(route = Screen.UserDetailScreen.route) {
                            UserDetailScreen()
                        }
                    }
                }
            }
        }
    }
}