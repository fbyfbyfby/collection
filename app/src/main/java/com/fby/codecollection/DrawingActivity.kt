package com.fby.codecollection

import android.animation.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fby.codecollection.util.dp
import com.fby.codecollection.view.ProvinceView
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
        val length = 200.dp
        val keyframe1 = Keyframe.ofFloat(0f, 0f)
        val keyframe2 = Keyframe.ofFloat(0.2f, 1.5f * length)
        val keyframe3 = Keyframe.ofFloat(0.8f, 0.6f * length)
        val keyframe4 = Keyframe.ofFloat(1f, 1f * length)
        val keyframeHolder = PropertyValuesHolder.ofKeyframe(
            "translationX",
            keyframe1,
            keyframe2,
            keyframe3,
            keyframe4
        )
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, keyframeHolder)
        animator.startDelay = 1000
        animator.duration = 2000
        //animator.start()
        val animator1 = ObjectAnimator.ofObject(view, "province",
            ProvinceView.ProvinceEvaluator(), "台湾省")
        //TypeEvaluator由动画完成度来算数值
        animator1.startDelay = 1000
        animator1.duration = 10000
        animator1.start()


//        view.animate()
//            .translationY(200.dp)
//            .withLayer()   在动画过程中开启硬件级别的莉萍缓冲
    }



}