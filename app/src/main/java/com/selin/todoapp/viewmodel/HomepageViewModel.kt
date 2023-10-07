package com.selin.todoapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.selin.todoapp.data.entity.Notes
import com.selin.todoapp.data.repo.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(var nrepo:NotesRepository): ViewModel() {
    var getNotes = MutableLiveData<List<Notes>>()

    init {
        getNotes()
    }

    fun delete(note_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.delete(note_id)
            getNotes()
        }
    }

    fun getNotes() {
        CoroutineScope(Dispatchers.Main).launch {
            getNotes.value = nrepo.getNotes()
        }
    }

    fun search(searchWord:String){
        CoroutineScope(Dispatchers.Main).launch {
            getNotes.value = nrepo.search(searchWord)
        }
    }

}