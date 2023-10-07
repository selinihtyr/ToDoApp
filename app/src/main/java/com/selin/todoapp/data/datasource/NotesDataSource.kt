package com.selin.todoapp.data.datasource

import android.util.Log
import com.selin.todoapp.data.entity.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import room.NotesDao

class NotesDataSource(var ndao: NotesDao) {

    suspend fun save(note_title: String){
        val newNote = Notes(0, note_title)
        ndao.save(newNote)
    }

    suspend fun update(note_id:Int, note_title: String){
        val updateNote = Notes(note_id, note_title)
        ndao.update(updateNote)
    }

    suspend fun delete(note_id: Int){
        val deleteNote = Notes(note_id, "")
        ndao.delete(deleteNote)
    }

    suspend fun getNotes() : List<Notes> = withContext(Dispatchers.IO){
        return@withContext ndao.getNotes()
    }

    suspend fun search(searchWord:String) : List<Notes> = withContext(Dispatchers.IO){
        return@withContext ndao.search(searchWord)
    }

}