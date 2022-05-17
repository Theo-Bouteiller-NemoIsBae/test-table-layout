package com.nemoisbae.plantsalletest.ui.widget

import android.content.Context
import android.widget.RelativeLayout
import com.nemoisbae.plantsalletest.data.Struc
import com.nemoisbae.plantsalletest.data.Type
import com.nemoisbae.plantsalletest.data.reversedependance.TableObject
import kotlin.math.roundToInt

open class Widget(val struc: Struc, val widthScalingRatio: Float, val heightScalingRatio: Float, context: Context): RelativeLayout(context) {
    fun getLayoutParamsForAdd(): LayoutParams {
        return LayoutParams(struc.getWidth(widthScalingRatio).roundToInt(), struc.getHeight(heightScalingRatio).roundToInt())
    }
}