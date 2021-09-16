package com.fby.codecollection

import android.animation.AnimatorSet
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
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

        val topFlipAnimator = ObjectAnimator.ofFloat(view, "topFlip", -60f)
        topFlipAnimator.startDelay = 200
        topFlipAnimator.duration = 1000

        val flipRotationAnimator = ObjectAnimator.ofFloat(view, "flipRotation", 270f)
        flipRotationAnimator.startDelay = 200
        flipRotationAnimator.duration = 1000

        val bottomFlipAnimator = ObjectAnimator.ofFloat(view, "bottomFlip", 60f)
        bottomFlipAnimator.startDelay = 1000
        bottomFlipAnimator.duration = 1000


        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator)
        //animatorSet.start()

        val bottomHolder = PropertyValuesHolder.ofFloat("bottomFlip", 60f)
        val flopHolder = PropertyValuesHolder.ofFloat("flipRotation", 270f)
        val topHolder = PropertyValuesHolder.ofFloat("topFlip", -60f)
        val holderAnimator =
            ObjectAnimator.ofPropertyValuesHolder(view, bottomHolder, flopHolder, topHolder)
        holderAnimator.startDelay = 1000
        holderAnimator.duration = 2000
        // holderAnimator.start()

//        val keyframe1 = Keyframe.ofFloat(0f, 0f)
//        val keyframe2 = Keyframe.ofFloat(0.2f,)
    }
}