package com.vvwxx.bangkit.mynoteapps.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vvwxx.bangkit.mynoteapps.database.Note
import com.vvwxx.bangkit.mynoteapps.repository.NoteRepository

class MainViewModel(application: Application) : ViewModel() {

    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()
}