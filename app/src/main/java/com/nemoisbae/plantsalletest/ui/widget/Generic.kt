package com.nemoisbae.plantsalletest.ui.widget

import android.widget.RelativeLayout
import com.nemoisbae.plantsalletest.data.Type

interface Generic {
    val type: Type

    fun getLayoutParamsForAdd(): RelativeLayout.LayoutParams
}