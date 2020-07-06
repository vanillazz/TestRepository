package com.ardyyy.dev.androidmvvm.data.local.room

import androidx.room.*
import com.ardyyy.dev.androidmvvm.data.local.entity.FavoriteMovie

@Dao
interface MovieAppDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(favMovie: FavoriteMovie)

    @Update
    fun update(favMovie: FavoriteMovie)

    @Delete
    fun delete(favMovie: FavoriteMovie)

    @Query("SELECT * from favoritemovie ORDER BY movieId ASC")
    fun getAllFavMovie(): List<FavoriteMovie>

    @Query("SELECT * from favoritemovie WHERE movieId = :movId")
    fun getFavMovieById(movId: Int): FavoriteMovie
}