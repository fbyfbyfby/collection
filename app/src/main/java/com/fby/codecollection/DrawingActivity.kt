package com.fby.codecollection

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fby.codecollection.util.dp
import kotlinx.android.synthetic.main.activity_drawing.*

class DrawingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing)
//        view.animate() // radius
//            .translationX(200.dp) // setTranslationX(10) setTranslationX(20) setTranslationX(40)
//            .translationY(100.dp)
//            .alpha(0.5f)
//            .scaleX(2f)
//            .scaleY(2f)
//            .rotation(90f)
//            .setStartDelay(1000)
        val animator = ObjectAnimator.ofFloat(view, "radius", 150.dp)
        animator.startDelay = 1000
        animator.start()
    }
}