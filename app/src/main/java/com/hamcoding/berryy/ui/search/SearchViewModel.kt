package com.hamcoding.berryy.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.hamcoding.berryy.data.SearchRepository
import com.hamcoding.berryy.data.model.KrxItem
import com.hamcoding.berryy.data.source.DetailApiClient
import com.hamcoding.berryy.data.source.KrxApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: SearchRepository
) : ViewModel() {

    private val _items = MutableStateFlow<List<KrxItem>>(emptyList())

    val word = MutableStateFlow("")
    val items: StateFlow<List<KrxItem>>
        get() = _items

    fun getResult() {
        viewModelScope.launch {
            _items.value = repository.getSearchResult(word.value).distinctBy {
                it.name
            }
        }
    }
}