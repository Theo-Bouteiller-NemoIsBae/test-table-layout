package com.nemoisbae.plantsalletest

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.nemoisbae.plantsalletest.data.Struc
import com.nemoisbae.plantsalletest.data.Type

class MainActivity : AppCompatActivity() {

    var dX: Float = 0f
    var dY: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datas: ArrayList<Struc> = arrayListOf(
            Struc(
                105.3f,
                56.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                584.3f,
                86.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                1500.3f,
                86.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                2557.3f,
                86.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                2149.3f,
                86.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                105.3f,
                420.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                584.3f,
                420.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                1500.3f,
                420.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                2557.3f,
                420.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                2149.3f,
                420.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                584.3f,
                754.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                1190.3f,
                904.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                1630.3f,
                904.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                2070.3f,
                902.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                1816.3f,
                1350.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                1816.3f,
                1684.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                584.3f,
                1201.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                584.3f,
                1535.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                105.3f,
                1201.45f,
                371f,
                633f,
                Type.TABLE
            ),
            Struc(
                2557.3f,
                1368.45f,
                371f,
                633f,
                Type.TABLE
            ),
            Struc(
                105.3f,
                2189.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                508.3f,
                2189.45f,
                371f,
                299f,
                Type.TABLE
            ),
            Struc(
                1136.91f,
                2172.97f,
                750f,
                299f,
                Type.WALL
            ),
            Struc(
                2364.91f,
                2091.17f,
                750f,
                299f,
                Type.WALL
            ),
            Struc(
                2070.31f,
                2638.61f,
                200f,
                400f,
                Type.WALL
            ),
            Struc(
                2019.31f,
                413.61f,
                200f,
                400f,
                Type.FLOWER
            ),
            Struc(
                545.61f,
                2009.58f,
                350f,
                200f,
                Type.FLOWER
            ),
            Struc(
                1277.66f,
                385.61f,
                300f,
                300f,
                Type.FLOWER
            ),
            Struc(
                290.81f,
                2672.97f,
                371f,
                299f,
                Type.TABLE
            ),
        )

        // get device dimensions
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

//        val w: Int = displayMetrics.widthPixels
//        val h: Int = displayMetrics.heightPixels

        val w: Int = 3000
        val h: Int = 3000

        val conf = Bitmap.Config.ARGB_8888 // see other conf types

        val bmp = Bitmap.createBitmap(w, h, conf) // this creates a MUTABLE bitmap

        val canvas = Canvas(bmp)

        canvas.drawARGB(255, 255, 255, 255);

        val paint = Paint()
        paint.strokeWidth = 30F
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        paint.isDither = true

        // circle center
        println("Width : "+displayMetrics.widthPixels)
        var center_x = (displayMetrics.widthPixels/2).toFloat()
        var center_y = (displayMetrics.heightPixels/2).toFloat()
        var radius = 300F

        // draw circle
//        canvas.drawCircle(center_x, center_y, radius, paint)
        // now bitmap holds the updated pixels

        datas.forEach { data ->
            when (data.type) {
                Type.WALL -> {
                    paint.color = Color.parseColor("#464646")
                    canvas.drawRect(data.posX,
                        data.posY,
                        data.posX + data.width,
                        data.posY + data.height,
                        paint
                    )
                }
                Type.TABLE -> {
                    paint.color = Color.parseColor("#0018ff")
                    canvas.drawRect(data.posX,
                        data.posY,
                        data.posX + data.width,
                        data.posY + data.height,
                        paint
                    )
                }
                Type.FLOWER -> {
                    paint.color = Color.parseColor("#0a4d10")
                    canvas.drawRect(data.posX,
                        data.posY,
                        data.posX + data.width,
                        data.posY + data.height,
                        paint
                    )
                }
            }
        }



        // set bitmap as background to ImageView
        this.findViewById<RelativeLayout>(R.id.imageView).background = BitmapDrawable(resources, bmp)
//        this.findViewById<RelativeLayout>(R.id.imageView).setOnTouchListener(this)
//        this.findViewById<ImageView>(R.id.imageView).visibility = View.GONE

// ready to draw on that bitmap through that canvas

//        this.findViewById<ImageView>(R.id.imageView)?

    }
}