package com.example.libtest.db

import com.example.libtest.clazz.Ticket
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.dao.RuntimeExceptionDao

class TicketDaoImp(ormLiteSqliteOpenHelper: OrmLiteSqliteOpenHelper) {

    private var ticketRED : RuntimeExceptionDao<Ticket, Long> = ormLiteSqliteOpenHelper.getRuntimeExceptionDao(Ticket::class.java)
}