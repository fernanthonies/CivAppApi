package com.fernanthonies.civapp.domain

import org.springframework.stereotype.Service
import javax.inject.Inject

@Service
class UserInteractor @Inject constructor(val repo: IUserInfo): IUserInteractor {
    override fun getUserId(userName: String, steamKey: String): String {
        return repo.getUserIdFromName(userName, steamKey)
    }
}