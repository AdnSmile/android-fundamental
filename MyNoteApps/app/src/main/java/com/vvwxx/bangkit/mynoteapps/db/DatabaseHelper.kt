package com.vvwxx.bangkit.mynoteapps.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.vvwxx.bangkit.mynoteapps.db.DatabaseContract.NoteColumn.Companion.TABLE_NAME

internal class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "dbnoteapp"

        private const val DATABASE_VERSION = 1

        private const val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME" +
                "(${DatabaseContract.NoteColumn._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${DatabaseContract.NoteColumn.TITLE} TEXT NOT NULL," +
                "${DatabaseContract.NoteColumn.DESCRIPTION} TEXT NOT NULL," +
                "${DatabaseContract.NoteColumn.DATE} TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}
