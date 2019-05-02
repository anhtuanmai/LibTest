package com.example.libtest.clazz

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ODRoute(@SerializedName("route_short_name") val routeShortName: String,
                   @SerializedName("route_long_name") val routeLongName: String,
                   @SerializedName("route_color") val routeColor: String) : Serializable