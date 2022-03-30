package com.nemoisbae.plantsalletest.data

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.MotionEvent
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import java.io.Console


class CustomView(context: Context): RelativeLayout(context) {

    var dX: Float = 0f
    var dY: Float = 0f

    override fun onTouchEvent(event: MotionEvent): Boolean {

        println("ON TOUCH EVENT")

        val w: Int = this.width
        val h: Int = this.height
//
//        val w: Int = 5000
//        val h: Int = 5000

        val conf = Bitmap.Config.ARGB_8888 // see other conf types

        val bmp = Bitmap.createBitmap(w, h, conf) // this creates a MUTABLE bitmap

        val canvas = Canvas(bmp)

        canvas.drawARGB(255, 78, 168, 186)

        val paint = Paint()
        paint.strokeWidth = 30F
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        paint.isDither = true
        paint.color = Color.parseColor("#FF0007")

        when (event.action){
            MotionEvent.ACTION_DOWN -> {
                dX = this.x - event.rawX
                dY = this.y - event.rawY
            }
            MotionEvent.ACTION_MOVE -> {
                println("move")
                canvas.drawCircle(event.rawX + dX, event.rawY + dY, 75f, paint)
                this.background = BitmapDrawable(resources, bmp)
            }
            MotionEvent.ACTION_UP -> {
                canvas.drawARGB(255, 78, 168, 186)
                this.background = BitmapDrawable(resources, bmp)
            }
        }

        return super.onTouchEvent(event)
    }
}