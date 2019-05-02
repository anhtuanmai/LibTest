package com.example.libtest.clazz

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ODPaidTrip(departureStop: ODStop?,
                 arriveStop: ODStop?,
                 route: ODRoute?,
                 val seats: Int,
                 @SerializedName("seats_prm") val seatsPrm: Int) : ODBaseTrip(departureStop, arriveStop, route), Serializable {
    override fun toString(): String {
        return "ODPaidTrip(departureStop=$departureStop, arriveStop=$arriveStop, route=$route, seats=$seats, seatsPrm=$seatsPrm)"
    }
}