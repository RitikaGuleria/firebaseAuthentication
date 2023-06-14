package com.example.firebaseauthentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauthentication.data.utils.AuthViewModel
import com.example.firebaseauthentication.di.navigation.AppNavHost
import com.example.firebaseauthentication.ui.auth.home.SignInScreen
import com.example.firebaseauthentication.ui.auth.home.SignUpScreen
import com.example.firebaseauthentication.ui.theme.FirebaseAuthenticationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseAuthenticationTheme {
                AppNavHost(viewModel)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirebaseAuthenticationTheme {

    }
}