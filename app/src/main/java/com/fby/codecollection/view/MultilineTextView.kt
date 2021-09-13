package com.fby.codecollection.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.fby.codecollection.R
import com.fby.codecollection.util.dp

/**

 * 作者：YS010051USR on 2021/9/10 13:51

 * 邮箱：fengboyang0412@gmail.com
top：从基线（x轴）向上绘制区域的最高点，此值为负值

ascent：单行文本，从基线（x轴）向上绘制的推荐最高点，此值为负值

baseline：基线，此值为0

descent：单行文本，从基线（x轴）向下绘制的推荐最低点，此值为正值

bottom：从基线（x轴）向下绘制区域的最低点，此值为正值

leading：推荐的额外行距，一般为0

作者：容华谢后
链接：https://www.jianshu.com/p/c3c9aea4cb01
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class MultilineTextView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val mPaint = Paint()

    private val IMAGE_SIZE = 150.dp
    private val IMAGE_PADDING = 50.dp
    val text =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur tristique urna tincidunt maximus viverra. Maecenas commodo pellentesque dolor ultrices porttitor. Vestibulum in arcu rhoncus, maximus ligula vel, consequat sem. Maecenas a quam libero. Praesent hendrerit ex lacus, ac feugiat nibh interdum et. Vestibulum in gravida neque. Morbi maximus scelerisque odio, vel pellentesque purus ultrices quis. Praesent eu turpis et metus venenatis maximus blandit sed magna. Sed imperdiet est semper urna laoreet congue. Praesent mattis magna sed est accumsan posuere. Morbi lobortis fermentum fringilla. Fusce sed ex tempus, venenatis odio ac, tempor metus."
    private var mBitmap: Bitmap
    private val measuredWidth = floatArrayOf(0f)
    private val fontMetrics = Paint.FontMetrics()

    init {
        mBitmap = getAvatar(IMAGE_SIZE.toInt())
        mPaint.isAntiAlias = true
        mPaint.textSize = 16.dp
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(mBitmap, width - IMAGE_SIZE, IMAGE_PADDING, mPaint)
        var start = 0
        var count = 0
        mPaint.getFontMetrics(fontMetrics)
        var maxWidth: Float
        var verticalOffset = -fontMetrics.top
//        while (start < text.length) {
//            maxWidth = if (verticalOffset + fontMetrics.bottom < IMAGE_PADDING || verticalOffset +
//                fontMetrics.top > IMAGE_PADDING + IMAGE_SIZE
//            ) {
//                width.toFloat()
//            } else {
//                width.toFloat() - IMAGE_SIZE
//            }
//            count = mPaint.breakText(text, start, text.length, true, maxWidth, measureWidth)
//            canvas.drawText(text, start, start + count, 0f, verticalOffset, mPaint)
//            start += count
//            verticalOffset += mPaint.fontSpacing
//        }
        while (start < text.length) {
            maxWidth = if (verticalOffset + fontMetrics.bottom < IMAGE_PADDING
                || verticalOffset + fontMetrics.top > IMAGE_PADDING + IMAGE_SIZE) {
                width.toFloat()
            } else {
                width.toFloat() - IMAGE_SIZE
            }
            count = mPaint.breakText(text, start, text.length, true, maxWidth, measuredWidth)
            canvas.drawText(text, start, start + count, 0f, verticalOffset, mPaint)
            start += count
            verticalOffset += mPaint.fontSpacing
        }
    }

    //paint.fontSpacing 两行字底之间的距离
    fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.apply {
            inJustDecodeBounds = true
            BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
            inJustDecodeBounds = false
            inDensity = options.outWidth   //原来的大小
            inTargetDensity = width       //目标大小
            return BitmapFactory.decodeResource(
                resources,
                R.drawable.avatar_rengwuxian,
                options
            )
        }
    }
}