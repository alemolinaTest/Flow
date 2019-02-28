package com.amolina.weather.climaflow.utils

import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation

/**
 * Created by Amolina on 02/02/17.
 */

object ViewAnimationUtils {

    fun scaleAnimateView(view: View) {
        val animation = ScaleAnimation(
                1.15f, 1f, 1.15f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)

        view.animation = animation
        animation.duration = 100
        animation.start()
    }

}// This class is not publicly instantiable
