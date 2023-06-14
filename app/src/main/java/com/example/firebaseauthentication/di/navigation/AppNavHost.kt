package com.example.firebaseauthentication.di.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauthentication.data.utils.AuthViewModel
import com.example.firebaseauthentication.ui.auth.home.HomeScreen
import com.example.firebaseauthentication.ui.auth.home.SignInScreen
import com.example.firebaseauthentication.ui.auth.home.SignUpScreen

@Composable
fun AppNavHost( viewModel: AuthViewModel,
    navController: NavHostController = rememberNavController(),
    startDestination:String= ROUTE_LOGIN
)
{
    NavHost(navController = navController, startDestination = startDestination)
    {
       composable(ROUTE_LOGIN)
       {
           SignInScreen(viewModel,navController = navController)
       }
       composable(ROUTE_SIGNUP)
       {
           SignUpScreen(viewModel,navController = navController)
       }
        composable(ROUTE_HOME)
        {
            HomeScreen(viewModel,navController)
        }


    }
}

