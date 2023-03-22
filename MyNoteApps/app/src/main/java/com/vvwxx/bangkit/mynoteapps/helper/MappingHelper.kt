package com.vvwxx.bangkit.mynoteapps.helper

import android.database.Cursor
import com.vvwxx.bangkit.mynoteapps.db.DatabaseContract
import com.vvwxx.bangkit.mynoteapps.entity.Note

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?) : ArrayList<Note> {
        val notesList = ArrayList<Note>()

        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumn._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumn.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumn.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumn.DATE))
                notesList.add(Note(id, title, description, date))
            }
        }
        return notesList
    }
}