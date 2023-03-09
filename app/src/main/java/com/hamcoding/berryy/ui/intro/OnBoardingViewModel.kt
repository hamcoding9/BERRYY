package com.hamcoding.berryy.ui.intro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamcoding.berryy.data.FavoriteStockRepository
import com.hamcoding.berryy.data.RemoteStockRepository
import com.hamcoding.berryy.data.model.RankItem
import com.hamcoding.berryy.data.model.Stock
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val remoteRepository: RemoteStockRepository,
    private val localRepository: FavoriteStockRepository,
) : ViewModel() {

    private val _items = MutableStateFlow<List<RankItem>>(emptyList())
    private val _onNextClick = MutableStateFlow<Boolean>(false)

    val items get() = _items
    val onNextClick get() = _onNextClick

    fun getRankList() {
        viewModelScope.launch {
            _items.value = remoteRepository.getRankList()
        }
    }

    fun setOnNextClick() {
        _onNextClick.value = true
    }

    fun insertFavoriteList(stockList: List<RankItem>) {
        val items = stockList.map {
            Stock(it.name, it.dividendAmount, it.dividendRate)
        }
        viewModelScope.launch {
            localRepository.addFavoriteStock(items)
        }
    }
}