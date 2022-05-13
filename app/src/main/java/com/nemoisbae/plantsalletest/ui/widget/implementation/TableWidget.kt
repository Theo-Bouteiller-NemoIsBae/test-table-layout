package com.nemoisbae.plantsalletest.ui.widget.implementation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.nemoisbae.plantsalletest.R
import com.nemoisbae.plantsalletest.data.Struc
import com.nemoisbae.plantsalletest.data.reversedependance.TableObject
import com.nemoisbae.plantsalletest.ui.widget.Widget

class TableWidget(struc: Struc, widthScalingRation: Float, heightScalingRation: Float, context: Context): Widget(struc, widthScalingRation, heightScalingRation, context) {

    init {
        val layout = LayoutInflater.from(context).inflate(R.layout.table_layout, null, false)
        this.addView(layout)

        this.findViewById<TextView>(R.id.table_layout_textview_1)?.text = (struc.contentObject as TableObject).name
        this.findViewById<TextView>(R.id.table_layout_textview_2)?.text = (struc.contentObject as TableObject).nombreDeCouverts.toString()
        this.findViewById<TextView>(R.id.table_layout_textview_3)?.text = (struc.contentObject as TableObject).tempEcoulé

        (this.findViewById<RelativeLayout>(R.id.table_layout_top_progress_relativelayout)?.layoutParams as LinearLayout.LayoutParams).apply {
            this.weight = ((struc.contentObject as TableObject).nbrSplit - (struc.contentObject as TableObject).nbrAsk).toFloat()
        }
        (this.findViewById<RelativeLayout>(R.id.table_layout_bottom_progress_relativelayout)?.layoutParams as LinearLayout.LayoutParams).apply {
            this.weight = ((struc.contentObject as TableObject).nbrAsk).toFloat()
        }

        this.findViewById<LinearLayout>(R.id.table_layout_background_linearlayout)?.let {
            it.weightSum = (struc.contentObject as TableObject).nbrSplit.toFloat()

//            var temp: Int = (struc.contentObject as TableObject).nbrSplit - (struc.contentObject as TableObject).nbrAsk



//            for (i in 0..(struc.contentObject as TableObject).nbrSplit) {
//                it.addView(RelativeLayout(context).apply {
//                    this.id = View.generateViewId()
//                    val lp = this.layoutParams
//
//                    if (temp > 0) {
//                        temp -= 1
//                    } else {
//                        this.setBackgroundColor(context.getColor(R.color.green))
//                    }
//                }, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f))
//            }
        }

        this.x = struc.getPosX(widthScalingRation)
        this.y = struc.getPosY(heightScalingRation)
    }

    fun timeUpdate() {

    }
}