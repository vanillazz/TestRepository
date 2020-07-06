package com.ardyyy.dev.androidmvvm.data.repository

import com.ardyyy.dev.androidmvvm.data.local.entity.FavoriteMovie
import com.ardyyy.dev.androidmvvm.data.local.room.MovieAppDao

class LocalRepository(private val movieDao: MovieAppDao) {

    fun getAllMovie() = movieDao.getAllFavMovie()
    fun getMovieById(movieID: Int) = movieDao.getFavMovieById(movieID)
    fun insertFavorite(movie: FavoriteMovie) = movieDao.insert(movie)
    fun deleteFavorite(movie: FavoriteMovie) = movieDao.delete(movie)
}