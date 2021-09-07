package com.fby.codecollection.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**

 * 作者：YS010051USR on 2021/9/7 13:53

 * 邮箱：fengboyang0412@gmail.com

 */
class PrimaryDrawView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint: Paint = Paint()
    var bluePaint: Paint = Paint()
    var greenPaint: Paint = Paint()

    init {
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.strokeWidth = 5f
        paint.color = Color.YELLOW
        bluePaint.style = Paint.Style.STROKE
        bluePaint.isAntiAlias = true
        bluePaint.strokeWidth = 5f
        bluePaint.color = Color.BLUE
        greenPaint.style = Paint.Style.STROKE
        greenPaint.isAntiAlias = true
        greenPaint.strokeWidth = 15f
        greenPaint.color = Color.GREEN
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.RED)
        canvas.drawCircle(0f, 0f, 100f, paint)
        canvas.drawPoint(0f, 0f, paint)
        canvas.drawPoint(100f, 100f, paint)
        canvas.drawRect(100f, 100f, 200f, 200f, paint)
        canvas.drawArc(50f, 50f, 350f, 200f, -110f, 100f, true, paint); // 绘制扇形
        canvas.drawOval(50f, 50f, 350f, 200f, paint)
        canvas.drawPoint(50f, 50f, bluePaint)
        canvas.drawPoint(350f, 200f, bluePaint)
        canvas.drawPoint(100f, 100f, bluePaint)
        canvas.drawPoint(500f, 300f, bluePaint)
        canvas.drawRoundRect(100f, 100f, 500f, 300f, 50f, 50f, paint)
        canvas.drawRoundRect(100f, 100f, 500f, 300f, 150f, 100f, bluePaint)

    }
}