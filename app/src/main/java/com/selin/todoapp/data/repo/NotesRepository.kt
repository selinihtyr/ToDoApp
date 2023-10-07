package com.selin.todoapp.data.repo

import android.util.Log
import com.selin.todoapp.data.datasource.NotesDataSource
import com.selin.todoapp.data.entity.Notes

class NotesRepository(var nds: NotesDataSource) {

    suspend fun save(note_title: String) = nds.save(note_title)

    suspend fun update(note_id:Int, note_title: String) = nds.update(note_id, note_title)

    suspend fun delete(note_id: Int) = nds.delete(note_id)

    suspend fun getNotes() : List<Notes> = nds.getNotes()

    suspend fun search(searchWord:String) : List<Notes> = nds.search(searchWord)

}