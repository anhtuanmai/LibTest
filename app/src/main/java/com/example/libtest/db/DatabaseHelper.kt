package com.example.libtest.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.libtest.clazz.Ticket
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import timber.log.Timber
import java.sql.SQLException

class DatabaseHelper constructor(context: Context) :
    OrmLiteSqliteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "com.example.libtest.db"
        private const val DATABASE_VERSION = 2
    }

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Ticket::class.java)
        } catch (e: SQLException) {
            Timber.e(e)
        }

    }

    override fun onUpgrade(
        database: SQLiteDatabase,
        connectionSource: ConnectionSource,
        oldVersion: Int,
        newVersion: Int
    ) {
        TableUtils.dropTable<Ticket, Int>(connectionSource, Ticket::class.java, false)
        onCreate(database, connectionSource)
    }
}