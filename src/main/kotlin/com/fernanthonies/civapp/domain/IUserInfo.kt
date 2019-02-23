package com.fernanthonies.civapp.domain

interface IUserInfo {
    fun getUserIdFromName(userName: String, steamKey: String): String
}