package com.example.libtest.clazz

import java.util.*

class SubSerializableA(name: String?=null, date: Date?=null, var weight: Int) : SerializableA(name, date) {

    override fun equals(other: Any?): Boolean {
        return if (other is SubSerializableA) {
            (name == other.name) && (date == other.date) && (weight == other.weight)
        } else {
            false
        }
    }

    override fun toString(): String {
        return "SubSerializableA(name=$name,date=$date,weight=$weight)"
    }
}