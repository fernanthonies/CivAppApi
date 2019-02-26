package com.fernanthonies.civapp.api

import com.fernanthonies.civapp.Components.DaggerServiceComponent
import com.fernanthonies.civapp.Properties.ApplicationProperties
import com.fernanthonies.civapp.data.User
import com.fernanthonies.civapp.domain.Exceptions.UserNotFoundException
import com.fernanthonies.civapp.domain.IUserInteractor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import javax.inject.Inject

@RestController
final class UserController(private val properties: ApplicationProperties) {

    @Inject
    lateinit var interactor: IUserInteractor

    init {
        DaggerServiceComponent.create().inject(this)
    }

    @GetMapping("/user/{name}/userId")
    fun userId(@PathVariable("name") userName: String): User {
        try {
            return interactor.getUserId(userName, properties.steamApiKey)
        } catch (ex: UserNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "No matching user name found", ex)
        }
    }

}