package com.ardyyy.dev.androidmvvm.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ardyyy.dev.androidmvvm.data.local.entity.FavoriteMovie

@Database(entities = [FavoriteMovie::class], version = 1)
abstract class MovieAppDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: MovieAppDatabase? = null

        fun getDatabase(context: Context): MovieAppDatabase {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    MovieAppDatabase::class.java,
                    "movieapp_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

            }
            return INSTANCE!!
        }
    }

    abstract fun movieDao(): MovieAppDao
}