package com.nemoisbae.plantsalletest.ui.objectbuilder

import android.content.Context
import com.nemoisbae.plantsalletest.data.Struc

interface ObjectBuilder {

    val struc: Struc
    val layer: Int

//    fun getDraw(context: Context, widthScalingRation: Float, heightScalingRation: Float): ArrayList<DrawData>
    fun getView(context: Context, widthScalingRation: Float, heightScalingRation: Float): ArrayList<DrawData>
}