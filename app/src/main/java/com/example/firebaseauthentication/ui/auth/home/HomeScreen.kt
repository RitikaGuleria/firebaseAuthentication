package com.example.firebaseauthentication.ui.auth.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firebaseauthentication.data.utils.AuthViewModel
import com.example.firebaseauthentication.di.navigation.ROUTE_HOME
import com.example.firebaseauthentication.di.navigation.ROUTE_LOGIN

@Composable
fun HomeScreen(viewModel: AuthViewModel?,navController: NavController)
{
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("User details are: ", fontSize = 24.sp)
        Text(text = viewModel?.currentUser?.displayName ?: "", fontSize = 16.sp)
        Text(text= viewModel?.currentUser?.email ?: "", fontSize = 16.sp)
        Button(onClick = { viewModel?.logout()
            navController?.navigate(ROUTE_LOGIN){
                popUpTo(ROUTE_HOME)
                {
                    inclusive=true
                }
            }
        }) {
            Text(text = "Log out")
        }
    }
}