package com.nemoisbae.plantsalletest.data

import android.graphics.RectF
import com.nemoisbae.plantsalletest.data.reversedependance.ContentObject

data class Struc(
    val posX: Float,
    val posY: Float,
    val width: Float,
    val height: Float,
    val type: Type,
    val contentObject: ContentObject
) {
    fun getRecF(widthScalingRation: Float, heightScalingRation: Float): RectF {
        return RectF(posX / widthScalingRation, posY / heightScalingRation, (posX / widthScalingRation) + (width / widthScalingRation), (posY / heightScalingRation) + (height/ heightScalingRation))
    }

    fun getWidth(widthScalingRation: Float): Float {
        return width / widthScalingRation
    }

    fun getHeight(heightScalingRation: Float): Float {
        return height / heightScalingRation
    }

    fun getPosX(widthScalingRation: Float): Float {
        return posX / widthScalingRation
    }

    fun getPosY(heightScalingRation: Float): Float {
        return posY / heightScalingRation
    }

    fun getLocalRecF(widthScalingRation: Float, heightScalingRation: Float): RectF {
        return RectF(0f, 0f, width / widthScalingRation, height / heightScalingRation)
    }
}
