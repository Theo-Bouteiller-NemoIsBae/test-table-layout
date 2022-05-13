package com.nemoisbae.plantsalletest.ui.objectbuilder.implementation

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.drawToBitmap
import com.nemoisbae.plantsalletest.R
import com.nemoisbae.plantsalletest.data.Struc
import com.nemoisbae.plantsalletest.data.reversedependance.TableObject
import com.nemoisbae.plantsalletest.ui.objectbuilder.DrawData
import com.nemoisbae.plantsalletest.ui.objectbuilder.ObjectBuilder
import org.w3c.dom.Text

class TableBuilder(override val struc: Struc, override val layer: Int) : ObjectBuilder {
    override fun getView(
        context: Context,
        widthScalingRation: Float,
        heightScalingRation: Float
    ): ArrayList<DrawData> {
//        val tempViewWrapper: RelativeLayout = RelativeLayout(context)
//        tempViewWrapper.id = View.generateViewId()
//        tempViewWrapper.setBackgroundColor(Color.BLUE)
//
//        val tempTextViewWrapper: TextView = TextView(context)
//        tempTextViewWrapper.id = View.generateViewId()
//        tempTextViewWrapper.text = (struc.contentObject as TableObject).name
//
//        tempViewWrapper.addView(tempTextViewWrapper)

        val layout = LayoutInflater.from(context).inflate(R.layout.table_layout, null, false)

        return arrayListOf(
            DrawData(3, struc.getRecF(widthScalingRation, heightScalingRation), layout),
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
//        paint.strokeWidth = 30F
//        paint.style = Paint.Style.FILL
//        paint.isAntiAlias = true
//        paint.isDither = true
//
//        paint.color = Color.parseColor("#0018ff")
//
////        canvas.drawRect(struc.getLocalRecF(widthScalingRation, heightScalingRation), paint)
//
//        val tempViewWrapper: RelativeLayout = RelativeLayout(context)
//        tempViewWrapper.id = View.generateViewId()
//        tempViewWrapper.setBackgroundColor(Color.LTGRAY)
//
//        val tempTextViewWrapper: TextView = TextView(context)
//        tempTextViewWrapper.id = View.generateViewId()
//        tempTextViewWrapper.text = (struc.contentObject as TableObject).name
//
//        tempViewWrapper.addView(tempTextViewWrapper)
//
////        canvas.drawBitmap(tempViewWrapper.drawToBitmap(Bitmap.Config.ARGB_8888), null, struc.getLocalRecF(widthScalingRation, heightScalingRation), null)
//
//
//        val bmpAlert = Bitmap.createBitmap(w, h, conf)
//
//        val canvasAlert = Canvas(bmpAlert)
//
//        val paintAlert = Paint()
//        paintAlert.strokeWidth = 30F
//        paintAlert.style = Paint.Style.FILL
//        paintAlert.isAntiAlias = true
//        paintAlert.isDither = true
//
//        paintAlert.color = Color.YELLOW
//
//        canvasAlert.drawCircle(((w / widthScalingRation) / 2f), ((h / heightScalingRation) / 2f), 20f, paintAlert)
//
//        return arrayListOf(
//            DrawData(3, struc.getRecF(widthScalingRation, heightScalingRation), bmp),
//            DrawData(10, struc.getRecF(widthScalingRation, heightScalingRation), bmpAlert)
//        )
//    }
}