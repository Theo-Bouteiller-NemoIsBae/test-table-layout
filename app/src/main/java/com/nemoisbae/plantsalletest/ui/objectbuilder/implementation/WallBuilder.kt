package com.nemoisbae.plantsalletest.ui.objectbuilder.implementation

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.nemoisbae.plantsalletest.data.Struc
import com.nemoisbae.plantsalletest.data.reversedependance.TableObject
import com.nemoisbae.plantsalletest.ui.objectbuilder.DrawData
import com.nemoisbae.plantsalletest.ui.objectbuilder.ObjectBuilder

class WallBuilder(override val struc: Struc, override val layer: Int) : ObjectBuilder {
    override fun getView(
        context: Context,
        widthScalingRation: Float,
        heightScalingRation: Float
    ): ArrayList<DrawData> {
        val tempViewWrapper: RelativeLayout = RelativeLayout(context)
        tempViewWrapper.id = View.generateViewId()
        tempViewWrapper.setBackgroundColor(Color.YELLOW)

        val tempTextViewWrapper: TextView = TextView(context)
        tempTextViewWrapper.id = View.generateViewId()
        tempTextViewWrapper.text = (struc.contentObject as TableObject).name

        tempViewWrapper.addView(tempTextViewWrapper)

        return arrayListOf(
            DrawData(3, struc.getRecF(widthScalingRation, heightScalingRation), tempViewWrapper),
//            DrawData(10, struc.getRecF(widthScalingRation, heightScalingRation), bmpAlert)
        )
    }

//    override fun getDraw(context: Context, widthScalingRation: Float, heightScalingRation: Float): ArrayList<DrawData> {
//        val w: Int = struc.width.toInt()
//        val h: Int = struc.height.toInt()
//
//        val conf = Bitmap.Config.ARGB_8888 // see other conf types
//
//        val bmp = Bitmap.createBitmap(w, h, conf) // this creates a MUTABLE bitmap
//
//        val canvas = Canvas(bmp)
//
//        val paint = Paint()
//        paint.strokeWidth = 5F
//        paint.style = Paint.Style.FILL
//        paint.isAntiAlias = true
//        paint.isDither = true
//
//        paint.color = Color.parseColor("#464646")
//        canvas.drawRect(struc.getLocalRecF(widthScalingRation, heightScalingRation), paint)
//
//        return arrayListOf(
//            DrawData(1, struc.getRecF(widthScalingRation, heightScalingRation), bmp)
//        )
//    }
}