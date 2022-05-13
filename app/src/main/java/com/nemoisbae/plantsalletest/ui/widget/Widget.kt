package com.nemoisbae.plantsalletest.ui.widget

import android.content.Context
import android.view.View
import android.widget.RelativeLayout
import com.nemoisbae.plantsalletest.data.Struc
import kotlin.math.roundToInt

open class Widget(val struc: Struc, val widthScalingRation: Float, val heightScalingRation: Float, context: Context): RelativeLayout(context) {
    fun getLayoutParamsForAdd(): LayoutParams {
        return LayoutParams(struc.getWidth(widthScalingRation).roundToInt(), struc.getHeight(heightScalingRation).roundToInt())
    }
}