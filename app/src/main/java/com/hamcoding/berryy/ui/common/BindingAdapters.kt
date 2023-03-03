package com.hamcoding.berryy.ui.common

import android.content.Context
import android.graphics.Outline
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.TextView
import androidx.annotation.DimenRes
import androidx.databinding.BindingAdapter
import kotlin.math.roundToInt

@BindingAdapter("setCornerRadius")
fun View.setCornerRadius(corner: Int) {
    val pixel = context.resources.getDimensionPixelSize(corner).toFloat()
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            outline.setRoundRect(0, 0, view.width, view.height, pixel)
        }
    }
    clipToOutline = true
}

@BindingAdapter("setDividendRate")
fun TextView.setDividendRate(text: String) {
    this.text = "배당수익률: ${text}%"
}

@BindingAdapter("setDividendAmount")
fun TextView.setDividendAmout(text: String) {
    this.text = "1주당 ${text}원"
}