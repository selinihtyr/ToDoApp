package com.selin.todoapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.selin.todoapp.data.repo.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel@Inject constructor(var nrepo:NotesRepository): ViewModel() {

    fun update(note_id:Int, note_title: String){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.update(note_id, note_title)
        }
    }
}