package com.nemoisbae.plantsalletest.ui.widget.implementation

import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.nemoisbae.plantsalletest.R
import com.nemoisbae.plantsalletest.data.Struc
import com.nemoisbae.plantsalletest.data.Type
import com.nemoisbae.plantsalletest.data.reversedependance.TableObject
import com.nemoisbae.plantsalletest.model.Note
import com.nemoisbae.plantsalletest.ui.widget.Generic
import com.nemoisbae.plantsalletest.ui.widget.Widget
import kotlin.math.roundToInt

class TableWidget(struc: Struc, widthScalingRation: Float, heightScalingRation: Float, context: Context): Widget(struc, widthScalingRation, heightScalingRation, context) {

    var sec: Int = 1

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

        this.findViewById<LinearLayout>(R.id.table_layout_background_linearlayout)?.weightSum = (struc.contentObject as TableObject).nbrSplit.toFloat()


        this.x = struc.getPosX(widthScalingRation)
        this.y = struc.getPosY(heightScalingRation)
    }

    fun getTableName(): String {
        return (struc.contentObject as TableObject).name
    }

    fun refreshData(note: Note) {

        Log.e("TRUC", "NextCount=${note.nextCount} callCount=${note.callCount}")

        this.findViewById<TextView>(R.id.table_layout_textview_1)?.text = note.groupingDisplay ?: "N/A"
        this.findViewById<TextView>(R.id.table_layout_textview_2)?.text = note.guestNumber.toString()
        this.findViewById<TextView>(R.id.table_layout_textview_3)?.text = "LOADED :)"
//        this.findViewById<TextView>(R.id.table_layout_textview_3)?.text = (struc.contentObject as TableObject).tempEcoulé

        val temp1 = (this.findViewById<RelativeLayout>(R.id.table_layout_top_progress_relativelayout)?.layoutParams as LinearLayout.LayoutParams).apply {
            this.weight = (note.nextCount - note.callCount).toFloat()
        }

        this.findViewById<RelativeLayout>(R.id.table_layout_top_progress_relativelayout)?.layoutParams = temp1

        val temp2 = (this.findViewById<RelativeLayout>(R.id.table_layout_bottom_progress_relativelayout)?.layoutParams as LinearLayout.LayoutParams).apply {
            this.weight = (note.callCount).toFloat()
        }

        this.findViewById<RelativeLayout>(R.id.table_layout_bottom_progress_relativelayout)?.layoutParams = temp2

        this.findViewById<LinearLayout>(R.id.table_layout_background_linearlayout)?.weightSum = note.nextCount.toFloat()

        postInvalidate()
    }

    fun timeUpdate() {
        sec += 1
        this.findViewById<TextView>(R.id.table_layout_textview_3)?.text = sec.toString()
    }
//
//    override val type: Type
//        get() = this.struc.type
//
//    override fun getLayoutParamsForAdd(): LayoutParams {
//        return LayoutParams(struc.getWidth(widthScalingRation).roundToInt(), struc.getHeight(heightScalingRation).roundToInt())
//    }
}