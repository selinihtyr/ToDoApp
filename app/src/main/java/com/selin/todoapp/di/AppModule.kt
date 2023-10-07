package com.selin.todoapp.di

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room
import com.selin.todoapp.data.datasource.NotesDataSource
import com.selin.todoapp.data.repo.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import room.DataBase
import room.NotesDao
import javax.inject.Singleton
import javax.sql.DataSource

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideNotesRepository(nds:NotesDataSource): NotesRepository {
        return NotesRepository(nds)
    }

    @Provides
    @Singleton
    fun provideNotesDataSource(ndao:NotesDao): NotesDataSource {
        return NotesDataSource(ndao)
    }

    @Provides
    @Singleton
    fun provideNotesDao(@ApplicationContext context:Context): NotesDao {
        val ds = Room.databaseBuilder(context, DataBase::class.java, "Notes.db")
            .createFromAsset("Notes.db").build()
        return ds.notesDao()
    }
}