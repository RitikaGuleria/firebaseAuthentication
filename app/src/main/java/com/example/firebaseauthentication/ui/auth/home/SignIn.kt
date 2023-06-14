package com.example.firebaseauthentication.ui.auth.home

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauthentication.data.Resource
import com.example.firebaseauthentication.data.utils.AuthViewModel
import com.example.firebaseauthentication.di.navigation.ROUTE_HOME
import com.example.firebaseauthentication.di.navigation.ROUTE_SIGNUP
import javax.annotation.meta.When

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(viewModel: AuthViewModel?,navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val loginFlow = viewModel?.loginFlow?.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        TextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ), modifier = Modifier.padding(8.dp)
        )

        TextField(
            value = password, onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ), modifier = Modifier.padding(8.dp)
        )
        Button(onClick = { viewModel?.login(email, password) }, modifier = Modifier.padding(18.dp))
        {
            Text(text = "Log in")
        }
        Text(text = "Click here to sign up", fontSize = 16.sp,modifier=Modifier.clickable {
            navController.navigate(ROUTE_SIGNUP)
        })

        loginFlow?.value?.let {
            when(it) {
                is Resource.Failure -> {
                    val context = LocalContext.current
                    Toast.makeText(context, it.exception.message,Toast.LENGTH_LONG).show()
                }
                Resource.Loading -> {
                    CircularProgressIndicator()
                }
                is Resource.Success -> {
                    LaunchedEffect(Unit){
                        navController?.navigate(ROUTE_HOME){
                            popUpTo(ROUTE_HOME){
                                inclusive=true
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun SignInScreenPreviewDark() {
    SignInScreen(null,rememberNavController())
}