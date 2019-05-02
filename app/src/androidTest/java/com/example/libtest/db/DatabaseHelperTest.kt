package com.example.libtest.db

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.example.libtest.clazz.*
import com.j256.ormlite.table.TableUtils
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception
import java.util.*

@RunWith(AndroidJUnit4::class)
class DatabaseHelperTest {

    companion object {
        private const val TAG = "TAG24"
    }

    private lateinit var databaseHelper: DatabaseHelper

    @Before
    fun setUp() {
        log("setUp start...")
        databaseHelper = DatabaseHelper(InstrumentationRegistry.getTargetContext())
//        TableUtils.clearTable(databaseHelper.connectionSource, Ticket::class.java)
        try {
            databaseHelper.readableDatabase.isOpen
        } catch (e: Exception) {
            fail("Exception = $e")
        }
    }

//    @Test
    fun test_saveData() {
        log("test_saveData start...")
        val inputTicket = Ticket().apply {
            subSerializableA = SubSerializableA("first", Date(2000, 0, 1), 100)
        }
        val ticketRED = databaseHelper.getRuntimeExceptionDao(Ticket::class.java)
        val created = ticketRED.create(inputTicket)
        assertEquals(1, created)

        val dbTickets = ticketRED.queryForAll()
        var count = 0
        for (entry in dbTickets) {
            if (entry.subSerializableA == inputTicket.subSerializableA) {
                count++
                log(entry.subSerializableA.toString())
            }
        }
        assertEquals(1, count)
        val deletedRows = ticketRED.delete(inputTicket)
        assert(deletedRows == 1)
    }

    @Test
    fun test_saveData2() {
        log("test_saveData start...")
        val inputTicket = Ticket().apply {
            odPaidTrip = ODPaidTrip(
                ODStop("1", "firstStop", null),
                ODStop("2", "secondStop", Date()),
                ODRoute("R1", "Route1", "AABBCC"),
                seats = 1,
                seatsPrm = 1
            )
        }
        val ticketRED = databaseHelper.getRuntimeExceptionDao(Ticket::class.java)
        val created = ticketRED.create(inputTicket)
        assertEquals(1, created)

        val dbTickets = ticketRED.queryForAll()
        var count = 0
        for (entry in dbTickets) {
            log(entry.odPaidTrip.toString())
            if (entry.odPaidTrip == inputTicket.odPaidTrip) {
                count++
            }
        }
        assertEquals(0, count)
//        val deletedRows = ticketRED.delete(inputTicket)
//        assert(deletedRows == 1)
    }

    @After
    fun tearDown() {
        log("tearDown.")
    }

    private fun log(msg: String) {
        System.out.println("$TAG: $msg")
    }
}