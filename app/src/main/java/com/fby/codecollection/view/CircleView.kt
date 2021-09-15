package com.fby.codecollection.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.fby.codecollection.util.dp

/**

 * 作者：YS010051USR on 2021/9/15 16:34

 * 邮箱：fengboyang0412@gmail.com

 */
class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    var radius = 50.dp
        set(value) {
            field = value
            invalidate()
        }

    init {
        mPaint.color = Color.parseColor("#00796B")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width / 2f, height / 2f, radius, mPaint)
    }
}