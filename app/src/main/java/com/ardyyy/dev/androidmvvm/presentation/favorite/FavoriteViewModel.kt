package com.ardyyy.dev.androidmvvm.presentation.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ardyyy.dev.androidmvvm.data.local.entity.FavoriteMovie
import com.ardyyy.dev.androidmvvm.data.repository.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(private val localRepository: LocalRepository) : ViewModel() {

    val movieData = MutableLiveData<List<FavoriteMovie>>()

    fun getAllFavMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            movieData.postValue(localRepository.getAllMovie())
        }
    }

}