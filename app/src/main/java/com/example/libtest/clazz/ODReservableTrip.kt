package com.example.libtest.clazz

import com.google.gson.annotations.SerializedName

class ODReservableTrip(@SerializedName("trip_token") val tripToken: String,
                       departureStop: ODStop,
                       arriveStop: ODStop,
                       route: ODRoute,
                       val price: Float,
                       val remaining: Int,
                       @SerializedName("remaining_prm") val remainingPRM: Int) : ODBaseTrip(departureStop, arriveStop, route) {
    override fun equals(other: Any?): Boolean {
        if (other is ODReservableTrip) {
            return this.tripToken == other.tripToken
        }
        return false
    }

    override fun hashCode(): Int {
        return tripToken.hashCode()
    }

    fun isSameTrip(other: ODReservableTrip): Boolean {
        return this.tripToken == other.tripToken
    }
}