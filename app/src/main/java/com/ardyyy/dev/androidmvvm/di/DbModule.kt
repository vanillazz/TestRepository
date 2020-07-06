package com.ardyyy.dev.androidmvvm.di

import com.ardyyy.dev.androidmvvm.data.local.room.MovieAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {

    single { MovieAppDatabase.getDatabase(androidContext()) }

    single {
        val movieDatabase: MovieAppDatabase = get()
        return@single movieDatabase.movieDao()
    }
}