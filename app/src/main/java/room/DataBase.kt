package room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.selin.todoapp.data.entity.Notes

@Database(entities = [Notes::class], version = 1)
abstract class DataBase :RoomDatabase(){
    abstract fun notesDao(): NotesDao
}

