package com.fby.codecollection.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.fby.codecollection.R
import com.fby.codecollection.util.dp

/**

 * 作者：YS010051USR on 2021/9/13 14:10

 * 邮箱：fengboyang0412@gmail.com

 */
class ClipAndCameraView2(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val BITMAP_SIZE = 200.dp
    private val BITMAP_PADDING = 100.dp
    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(BITMAP_SIZE.toInt())
    private val camera = Camera()
    private val clipPath = Path().apply {
        addOval(0f, 0f, BITMAP_SIZE, BITMAP_SIZE, Path.Direction.CCW)
    }

    init {
        camera.rotateX(30f)

        camera.setLocation(0f, 0f, -5 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //先移动后旋转,写的时候下面先旋转
        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-30f)
        canvas.clipRect(- BITMAP_SIZE, - BITMAP_SIZE, BITMAP_SIZE, 0f)
        canvas.rotate(30f)
        canvas.translate(- (BITMAP_PADDING + BITMAP_SIZE / 2), - (BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, mPaint)
        canvas.restore()

        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-30f)
        camera.applyToCanvas(canvas)
        canvas.clipRect(- BITMAP_SIZE, 0f, BITMAP_SIZE, BITMAP_SIZE)

        canvas.rotate(30f)
        canvas.translate(- (BITMAP_PADDING + BITMAP_SIZE / 2), - (BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, mPaint)
        canvas.restore()
    }

    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
    }
}