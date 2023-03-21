package com.hamcoding.berryy.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamcoding.berryy.data.RemoteStockRepository
import com.hamcoding.berryy.data.model.DividendItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val remoteRepository: RemoteStockRepository,
) : ViewModel() {

    private val _items = MutableStateFlow<List<DividendItem>>(emptyList())

    val items: StateFlow<List<DividendItem>>
        get() = _items
    val testMap = mapOf(
        "2020" to 1000,
        "2021" to 2300,
        "2022" to 3000,
    )

    fun getDetail(code: String) {
        viewModelScope.launch {
            _items.value = remoteRepository.getDetailList(code)
        }
    }

}