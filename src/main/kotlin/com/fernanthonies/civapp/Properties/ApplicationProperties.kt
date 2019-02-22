package com.fernanthonies.civapp.Properties

import org.springframework.boot.context.properties.ConfigurationProperties
import javax.inject.Inject

@ConfigurationProperties("api")
class ApplicationProperties @Inject constructor(){
    lateinit var steamApiKey: String
    lateinit var civ5AppId: String
    lateinit var civ6AppId: String
}