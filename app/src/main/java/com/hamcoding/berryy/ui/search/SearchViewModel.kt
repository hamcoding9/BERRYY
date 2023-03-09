package com.hamcoding.berryy.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamcoding.berryy.data.RemoteStockRepository
import com.hamcoding.berryy.data.model.KrxItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: RemoteStockRepository
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