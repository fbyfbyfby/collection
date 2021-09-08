package com.fby.codecollection.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**

 * 作者：YS010051USR on 2021/9/8 09:34

 * 邮箱：fengboyang0412@gmail.com

 */
class PathView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint()
    var path = Path()

    init {
        path.addArc(200f, 200f, 400f, 400f, -225f, 225f)
        path.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false)
        path.lineTo(400f, 542f)
//addXXX 添加了完整封闭图形
//xxxTo 只是添加了一条线
        // addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo() 。
//forceMoveTo 参数的意思是，绘制是要「抬一下笔移动过去」，还是「直接拖着笔过去」，区别在于是否留下移动的痕迹 true=无痕迹 false=有痕迹
        //这跟之前的弧形已经是不封闭的另一个图形了，因此，在接下来使用lineTo（）方法将图形封闭的时候，封闭的只是第二段弧与中心点组成的图形
        //forceMoveTo的值决定图案是否连续，也就间接决定了调用path.close()时，封闭图形的连接
        //使用描边paint.setStyle(Style.STROKE); 想封闭图形用 path.close()
        //close() 和 lineTo(起点坐标) 是完全等价的

        paint.isAntiAlias = true
        paint.strokeWidth = 5f
        paint.color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)
    }
}