package com.nemoisbae.plantsalletest.data

import android.graphics.RectF

data class Struc(
    val posX: Float,
    val posY: Float,
    val width: Float,
    val height: Float,
    val type: Type
) {
    fun getRecF(widthScalingRation: Float, heightScalingRation: Float): RectF {
        return RectF(posX / widthScalingRation, posY / heightScalingRation, (posX / widthScalingRation) + (width / widthScalingRation), (posY / heightScalingRation) + (height/ heightScalingRation))
    }

    fun getLocalRecF(widthScalingRation: Float, heightScalingRation: Float): RectF {
        return RectF(0f, 0f, width / widthScalingRation, height / heightScalingRation)
    }
}
