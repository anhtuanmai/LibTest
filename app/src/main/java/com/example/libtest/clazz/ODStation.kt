package com.example.libtest.clazz

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class ODStation(
        @SerializedName("stop_id") val stopId: String,
        @SerializedName("stop_name") val stopName: String
) : Serializable {
    override fun equals(other: Any?): Boolean {
        return if (other is ODStation) {
            this.stopId == other.stopId
        }
        else {
            false
        }
    }

    override fun hashCode(): Int {
        return stopId.hashCode()
    }
}