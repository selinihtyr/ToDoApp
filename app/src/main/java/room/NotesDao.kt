package room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.selin.todoapp.data.entity.Notes

@Dao
interface NotesDao {
    @Query("SELECT * FROM Note")
    suspend fun getNotes(): List<Notes>

    @Insert
    suspend fun save(note:Notes)

    @Update
    suspend fun update(note:Notes)

    @Delete
    suspend fun delete(note:Notes)

    @Query("SELECT * FROM Note WHERE note_title like '%' || :searchWord || '%'")
    suspend fun search(searchWord:String): List<Notes>

}