package com.example.libtest.clazz

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class ODBaseTrip(@SerializedName("origin") val departureStop: ODStop?,
                      @SerializedName("destination") val arriveStop: ODStop?,
                      val route: ODRoute?) : Serializable {

    /**
     * @return -1 if data is not sufficient
     */
    fun getDurationInMs(): Long {
        val arriveDate = arriveStop?.date
        val departureDate = departureStop?.date
        return if ((arriveDate != null) && (departureDate != null)) {
            arriveDate.time - departureDate.time
        }
        else {
            -1
        }
    }
}