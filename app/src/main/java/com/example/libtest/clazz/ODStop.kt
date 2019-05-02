package com.example.libtest.clazz

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * subclass of ODStation which provides {@property #timestamp}
 * @param isoDate in formate yyyy-MM-dd'T'HH:mm:ssZ
 */
class ODStop(stopId: String, stopName: String, private val isoDate: Date?= null) : ODStation(stopId, stopName), Serializable {

    @SerializedName("date")
    val date: Date? = isoDate

    override fun toString(): String {
        return "ODStop(stopId=$stopId, stopName=$stopName, date=$date)"
    }
}
