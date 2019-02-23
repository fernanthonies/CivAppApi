package com.fernanthonies.civapp.domain

interface IUserInteractor {
    fun getUserId(userName: String, steamKey: String): String
}