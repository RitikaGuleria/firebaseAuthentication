package com.example.firebaseauthentication.data

import com.google.firebase.auth.FirebaseUser

interface AuthRepository
{
    var currentUser : FirebaseUser?
    suspend fun login(email:String,password:String) : Resource<FirebaseUser>
    suspend fun signup(name:String,email: String,password: String) : Resource<FirebaseUser>
    fun logout()
}