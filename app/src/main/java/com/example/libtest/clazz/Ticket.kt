package com.example.libtest.clazz

import com.j256.ormlite.field.DataType
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "ticket")
class Ticket {

    companion object {
        const val Column_1 =     "odPaidTrip"
        const val Column_2 =     "subSerializableA"
    }

    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true)
    val id: Int = 0

    @DatabaseField(columnName = Column_1, dataType = DataType.SERIALIZABLE)
    var odPaidTrip: ODPaidTrip? = null

    @DatabaseField(columnName = Column_2, dataType = DataType.SERIALIZABLE)
    var subSerializableA = SubSerializableA(null, null, 20)
}