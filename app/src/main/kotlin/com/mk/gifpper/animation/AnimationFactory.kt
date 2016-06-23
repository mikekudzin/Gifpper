package com.mk.gifpper.animation

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View

object AnimationFactory {
    fun createHotAnimator(view: View): Animator {
        var animatorSet = AnimatorSet()
        var alphaAnimation = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.5f)
        alphaAnimation.repeatCount = ValueAnimator.INFINITE
        alphaAnimation.repeatMode = ValueAnimator.REVERSE
        var stretchHeight = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.1f)
        stretchHeight.repeatCount = ValueAnimator.INFINITE
        stretchHeight.repeatMode = ValueAnimator.REVERSE
        var stretchWidth = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.1f)
        stretchWidth.repeatCount = ValueAnimator.INFINITE
        stretchWidth.repeatMode = ValueAnimator.REVERSE

        animatorSet.play(alphaAnimation).with(stretchHeight).with(stretchWidth)
        animatorSet.duration = 1500

        return animatorSet
    }
}