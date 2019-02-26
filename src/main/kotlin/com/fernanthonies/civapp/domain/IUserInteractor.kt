package com.fernanthonies.civapp.domain

import com.fernanthonies.civapp.data.User

interface IUserInteractor {
    fun getUserId(userName: String, steamKey: String): User
}