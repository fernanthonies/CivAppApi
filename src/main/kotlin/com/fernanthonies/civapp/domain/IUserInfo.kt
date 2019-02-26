package com.fernanthonies.civapp.domain

import com.fernanthonies.civapp.data.User

interface IUserInfo {
    fun getUserIdFromName(userName: String, steamKey: String): User
}