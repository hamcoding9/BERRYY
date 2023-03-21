package com.hamcoding.berryy.ui.common

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter

class BarChartView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var data: Map<String, Float> = emptyMap()
    private var color: Int = 0
    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val yearTextSpace = 60f
        val amountTextSpace = 40f
        val maxValue = data.values.max()
        val scale = ( height - amountTextSpace ) / maxValue

        val chartData = data.values.map { value ->
            height - value * scale
        }
        val itemWidth = (width) / chartData.count()
        val barWidth = itemWidth * 0.7f

        var x = itemWidth.toFloat() / 2
        paint.color = color
        paint.strokeWidth = barWidth
        chartData.forEach { value ->
            canvas.drawLine(x, height - yearTextSpace, x, value, paint)
            x += itemWidth
        }

        paint.color = Color.BLACK
        paint.textSize = 40f
        paint.textAlign = Paint.Align.CENTER
        x = itemWidth.toFloat() / 2
        data.keys.forEach { year ->
            canvas.drawText(year, x, height.toFloat(), paint)
            x += itemWidth
        }

        paint.textSize = 30f
        x = itemWidth.toFloat() / 2
        var index = 0
        val topSpace = 5f
        data.values.forEach { amount ->
            canvas.drawText(amount.toInt().toString(), x, chartData[index] - topSpace, paint)
            x += itemWidth
            index += 1
        }
    }

    fun setData(data: Map<String, Float>) {
        this.data = data
    }

    fun setColor(color: Int) {
        this.color = color
    }
}

@BindingAdapter("data")
fun BarChartView.setData(data: Map<String, Int>) {
    val mappedData = data.mapValues {
        it.value.toFloat()
    }
    setData(mappedData)
}

@BindingAdapter("chartColor")
fun BarChartView.setChartColor(color: Int) {
    setColor(color)
}