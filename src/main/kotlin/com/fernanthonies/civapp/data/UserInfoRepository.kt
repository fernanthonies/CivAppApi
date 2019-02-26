package com.fernanthonies.civapp.data

import com.fernanthonies.civapp.domain.Exceptions.UserNotFoundException
import com.fernanthonies.civapp.domain.IUserInfo
import khttp.get
import org.springframework.stereotype.Repository
import javax.inject.Inject

@Repository
class UserInfoRepository @Inject constructor(): IUserInfo {
    override fun getUserIdFromName(userName: String, steamKey: String): User {
        val payload = mapOf("key" to steamKey, "vanityurl" to userName)
        val result = get("http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/", params=payload)
        val success = result.jsonObject.getJSONObject("response").get("success")
        return if (success == 1) {
            User(result.jsonObject.getJSONObject("response").get("steamid").toString())
        } else {
            throw UserNotFoundException()
        }
    }
}