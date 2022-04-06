package com.nemoisbae.plantsalletest.ui.objectbuilder.implementation

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.nemoisbae.plantsalletest.data.Struc
import com.nemoisbae.plantsalletest.ui.objectbuilder.DrawData
import com.nemoisbae.plantsalletest.ui.objectbuilder.ObjectBuilder

class TableBuilder(override val struc: Struc, override val layer: Int) : ObjectBuilder {
    override fun getDraw(context: Context, widthScalingRation: Float, heightScalingRation: Float): ArrayList<DrawData> {
        val w: Int = struc.width.toInt()
        val h: Int = struc.height.toInt()

        val conf = Bitmap.Config.ARGB_8888 // see other conf types

        val bmp = Bitmap.createBitmap(w, h, conf) // this creates a MUTABLE bitmap

        val canvas = Canvas(bmp)

        val paint = Paint()
        paint.strokeWidth = 30F
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        paint.isDither = true

        paint.color = Color.parseColor("#0018ff")

        canvas.drawRect(struc.getLocalRecF(widthScalingRation, heightScalingRation), paint)

        val bmpAlert = Bitmap.createBitmap(w, h, conf)

        val canvasAlert = Canvas(bmpAlert)

        val paintAlert = Paint()
        paintAlert.strokeWidth = 30F
        paintAlert.style = Paint.Style.FILL
        paintAlert.isAntiAlias = true
        paintAlert.isDither = true

        paintAlert.color = Color.YELLOW

        canvasAlert.drawCircle(((w / widthScalingRation) / 2f), ((h / heightScalingRation) / 2f), 20f, paintAlert)

        return arrayListOf(
            DrawData(3, struc.getRecF(widthScalingRation, heightScalingRation), bmp),
            DrawData(10, struc.getRecF(widthScalingRation, heightScalingRation), bmpAlert)
        )
    }
}