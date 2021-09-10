package com.fby.codecollection.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.fby.codecollection.util.dp

/**

 * 作者：YS010051USR on 2021/9/10 09:48

 * 邮箱：fengboyang0412@gmail.com

 */
private val CIRCLE_COLOR = Color.parseColor("#90A4AE")
private val HIGHLIGHT_COLOR = Color.parseColor("#FF4081")
private val RING_WIDTH = 20.dp
private val RADIUS = 150.dp

class CustomTextView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint()
    private val fontMetrics = Paint.FontMetrics()
    private val bounds = Rect()

    init {
        paint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.apply {
            style = Paint.Style.STROKE
            color = CIRCLE_COLOR
            strokeWidth = RING_WIDTH
        }
        canvas.drawCircle(width / 2f, height / 2f, RADIUS, paint)
        paint.apply {
            color = HIGHLIGHT_COLOR
            strokeCap = Paint.Cap.ROUND

        }
        canvas.drawArc(
            width / 2f - RADIUS,
            height / 2f - RADIUS,
            width / 2f + RADIUS,
            height / 2f + RADIUS, -90f, 225f, false, paint
        )
        paint.apply {
            textSize = 100.dp
            style = Paint.Style.FILL
            //    this.fontMetrics = this@CustomTextView.fontMetrics
            getFontMetrics(this@CustomTextView.fontMetrics)
            getTextBounds("aaaa", 0, "aaaa".length, bounds)
        }
//        canvas.drawText(
//            "aaaa",
//            width / 2f - (bounds.right - bounds.left) / 2,
//            height / 2f - (fontMetrics.ascent + fontMetrics.descent) / 2f,
//            paint
//        ) ascent descent是文字的最核心部分
        canvas.drawText(
            "aaaa",
            width / 2f ,
            height / 2f - (bounds.top + bounds.bottom) / 2f,
            paint
        )
    }
}