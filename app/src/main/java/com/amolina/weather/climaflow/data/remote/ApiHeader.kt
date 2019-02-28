package com.amolina.weather.climaflow.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.amolina.weather.climaflow.di.ApiInfo

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Amolina on 02/02/17.
 */

@Singleton
class ApiHeader @Inject
constructor(val publicApiHeader: PublicApiHeader, val protectedApiHeader: ProtectedApiHeader) {

    class PublicApiHeader @Inject
    constructor(
        @param:ApiInfo @field:Expose
        @field:SerializedName("APPID")
        var apiKey: String?
    )

    class ProtectedApiHeader(
        @field:Expose
        @field:SerializedName("APPID")
        var apiKey: String?, @field:Expose
        @field:SerializedName("access_token")
        var accessToken: String?
    )
}
