package com.fernanthonies.civapp.domain

import com.fernanthonies.civapp.data.User
import org.springframework.stereotype.Service
import javax.inject.Inject

@Service
class UserInteractor @Inject constructor(val repo: IUserInfo): IUserInteractor {
    override fun getUserId(userName: String, steamKey: String): User {
        return repo.getUserIdFromName(userName, steamKey)
    }
}