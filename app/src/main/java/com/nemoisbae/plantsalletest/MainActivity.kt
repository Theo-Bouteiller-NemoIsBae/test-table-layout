package com.nemoisbae.plantsalletest

import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nemoisbae.plantsalletest.data.Struc
import com.nemoisbae.plantsalletest.data.Type
import com.nemoisbae.plantsalletest.data.reversedependance.TableObject
import com.nemoisbae.plantsalletest.model.Note
import com.nemoisbae.plantsalletest.model.PtxBillListItem
import com.nemoisbae.plantsalletest.ui.PlanDeSalle
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    var dX: Float = 0f
    var dY: Float = 0f

    // TODO:: check car bcp spam
    val REFRESH_API = 5
    val REFRESH_API_TIME_UNIT = TimeUnit.SECONDS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datas: ArrayList<Struc> = arrayListOf(
            Struc(
                105.3f,
                56.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
            Struc(
                584.3f,
                86.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
            Struc(
                1500.3f,
                86.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject(name = "T4")
            ),
            Struc(
                2557.3f,
                86.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject(name = "T3")
            ),
            Struc(
                2149.3f,
                86.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject(name = "T2")
            ),
            Struc(
                105.3f,
                420.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject(name = "T1")
            ),
            Struc(
                584.3f,
                420.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject(name = "T23")
            ),
            Struc(
                1500.3f,
                420.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
            Struc(
                2557.3f,
                420.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
            Struc(
                2149.3f,
                420.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
            Struc(
                584.3f,
                754.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
            Struc(
                1190.3f,
                904.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
            Struc(
                1630.3f,
                904.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
            Struc(
                2070.3f,
                902.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
            Struc(
                1816.3f,
                1350.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
//            Struc(
//                1816.3f,
//                1684.45f,
//                371f,
//                299f,
//                Type.TABLE
//            ),
            Struc(
                584.3f,
                1201.45f,
                371f,
                299f,
                Type.TABLE,
                TableObject()
            ),
//            Struc(
//                584.3f,
//                1535.45f,
//                371f,
//                299f,
//                Type.TABLE
//            ),
            Struc(
                105.3f,
                1201.45f,
                371f,
                233f,
                Type.TABLE,
                TableObject()
            ),
            Struc(
                2557.3f,
                1368.45f,
                371f,
                233f,
                Type.TABLE,
                TableObject()
            ),
//            Struc(
//                105.3f,
//                2189.45f,
//                371f,
//                299f,
//                Type.TABLE
//            ),
//            Struc(
//                508.3f,
//                2189.45f,
//                371f,
//                299f,
//                Type.TABLE
//            ),
//            Struc(
//                1136.91f,
//                2172.97f,
//                750f,
//                299f,
//                Type.WALL
//            ),
//            Struc(
//                2364.91f,
//                2091.17f,
//                750f,
//                299f,
//                Type.WALL
//            ),
//            Struc(
//                2070.31f,
//                2638.61f,
//                200f,
//                400f,
//                Type.WALL
//            ),
            Struc(
                2019.31f,
                413.61f,
                200f,
                400f,
                Type.FLOWER,
                TableObject()
            ),
//            Struc(
//                545.61f,
//                2009.58f,
//                350f,
//                200f,
//                Type.FLOWER
//            ),
//            Struc(
//                290.81f,
//                2672.97f,
//                371f,
//                299f,
//                Type.TABLE
//            ),
            Struc(
                1277.66f,
                385.61f,
                300f,
                300f,
                Type.FLOWER,
                TableObject()
            )
        )

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        val display: Display = windowManager.defaultDisplay
        val size = Point()
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(size)
        } else {
            display.getSize(size) // correct for devices with hardware navigation buttons
        }

        val w: Int = size.x
        val h: Int = size.y

        val scalingRatio: Float = (3000f / w)

        val planDeSalle = PlanDeSalle(this, displayMetrics.widthPixels, displayMetrics.heightPixels) {
            val temp: ArrayList<Note> = arrayListOf()
            temp.addAll(loadData())
            temp
        }
        this.findViewById<RelativeLayout>(R.id.imageView)?.addView(planDeSalle, RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT))
        planDeSalle.setData(datas)

        var isVisible: Boolean = true
        val layerToChange = 10

//        this.findViewById<RelativeLayout>(R.id.imageView)?.addView(Button(this).apply {
//            this.setOnClickListener {
//                var result: Boolean? = null
//
//                if (isVisible) {
//                    isVisible = false
//                    result = planDeSalle.changeLayerVisibility(View.GONE, layerToChange)
//                    this.text = "SHOW LAYER $layerToChange"
//                } else {
//                    isVisible = true
//                    result = planDeSalle.changeLayerVisibility(View.VISIBLE, layerToChange)
//                    this.text = "HIDE LAYER $layerToChange"
//                }
//
//                println("Result of change visibility of layer $layerToChange: $result \r\n")
//            }
//
//            this.text = "HIDE LAYER $layerToChange"
//        })

        // get device dimensions
//        val displayMetrics = DisplayMetrics()
//        windowManager.defaultDisplay.getMetrics(displayMetrics)
//
////        val w: Int = displayMetrics.widthPixels
////        val h: Int = displayMetrics.heightPixels
//
//        val w: Int = 3000
//        val h: Int = 3000
//
//        val conf = Bitmap.Config.ARGB_8888 // see other conf types
//
//        val bmp = Bitmap.createBitmap(w, h, conf) // this creates a MUTABLE bitmap
//
//        val canvas = Canvas(bmp)
//
//        canvas.drawARGB(255, 255, 255, 255);
//
//        val paint = Paint()
//        paint.strokeWidth = 30F
//        paint.style = Paint.Style.FILL
//        paint.isAntiAlias = true
//        paint.isDither = true
//
//        // circle center
//        println("Width : "+displayMetrics.widthPixels)
//        var center_x = (displayMetrics.widthPixels/2).toFloat()
//        var center_y = (displayMetrics.heightPixels/2).toFloat()
//        var radius = 300F
//
//        // draw circle
////        canvas.drawCircle(center_x, center_y, radius, paint)
//        // now bitmap holds the updated pixels
//
//        datas.forEach { data ->
//            when (data.type) {
//                Type.WALL -> {
//                    paint.color = Color.parseColor("#464646")
//                    canvas.drawRect(data.posX,
//                        data.posY,
//                        data.posX + data.width,
//                        data.posY + data.height,
//                        paint
//                    )
//                }
//                Type.TABLE -> {
//                    paint.color = Color.parseColor("#0018ff")
//                    canvas.drawRect(data.posX,
//                        data.posY,
//                        data.posX + data.width,
//                        data.posY + data.height,
//                        paint
//                    )
//                }
//                Type.FLOWER -> {
//                    paint.color = Color.parseColor("#0a4d10")
//                    canvas.drawRect(data.posX,
//                        data.posY,
//                        data.posX + data.width,
//                        data.posY + data.height,
//                        paint
//                    )
//                }
//            }
//        }



        // set bitmap as background to ImageView
//        this.findViewById<RelativeLayout>(R.id.imageView).background = BitmapDrawable(resources, bmp)
//        this.findViewById<RelativeLayout>(R.id.imageView).setOnTouchListener(this)
//        this.findViewById<ImageView>(R.id.imageView).visibility = View.GONE

// ready to draw on that bitmap through that canvas

//        this.findViewById<ImageView>(R.id.imageView)?

        this.findViewById<Button>(R.id.button)?.setOnClickListener {
            val temp: ArrayList<Note> = arrayListOf()
            temp.addAll(loadData())
            planDeSalle.refreshTable(temp)
        }
    }

    private fun loadData(): List<Note> {
        val json: String = "[{\"transactionId\":20000115758,\"groupingDisplay\":\"T4\",\"profitCenterId\":1,\"profitCenterName\":\"RESTAURANT\",\"posNumber\":4,\"stationId\":20,\"stationName\":\"ANDROID1\",\"waiterNumber\":3,\"numberOfBills\":1,\"guests\":1,\"tag\":\"\",\"totalIncludingTaxes\":13900,\"maxPaymentLineNumber\":0,\"customer\":null,\"busyGrouping\":{\"nextCount\":3,\"callCount\":1,\"alert\":false}},{\"transactionId\":20000115568,\"groupingDisplay\":\"T3\",\"profitCenterId\":1,\"profitCenterName\":\"RESTAURANT\",\"posNumber\":4,\"stationId\":20,\"stationName\":\"ANDROID1\",\"waiterNumber\":3,\"numberOfBills\":1,\"guests\":1,\"tag\":\"\",\"totalIncludingTaxes\":13900,\"maxPaymentLineNumber\":0,\"customer\":null,\"busyGrouping\":{\"nextCount\":2,\"callCount\":2,\"alert\":false}},{\"transactionId\":20000115549,\"groupingDisplay\":\"T23\",\"profitCenterId\":1,\"profitCenterName\":\"RESTAURANT\",\"posNumber\":4,\"stationId\":20,\"stationName\":\"ANDROID1\",\"waiterNumber\":3,\"numberOfBills\":0,\"guests\":1,\"tag\":\"\",\"totalIncludingTaxes\":13900,\"maxPaymentLineNumber\":0,\"customer\":null,\"busyGrouping\":{\"nextCount\":0,\"callCount\":0,\"alert\":false}},{\"transactionId\":20000115315,\"groupingDisplay\":\"T2\",\"profitCenterId\":1,\"profitCenterName\":\"RESTAURANT\",\"posNumber\":4,\"stationId\":20,\"stationName\":\"ANDROID1\",\"waiterNumber\":3,\"numberOfBills\":0,\"guests\":1,\"tag\":\"\",\"totalIncludingTaxes\":13900,\"maxPaymentLineNumber\":0,\"customer\":null,\"busyGrouping\":{\"nextCount\":2,\"callCount\":0,\"alert\":false}},{\"transactionId\":20000114061,\"groupingDisplay\":\"T1\",\"profitCenterId\":1,\"profitCenterName\":\"RESTAURANT\",\"posNumber\":4,\"stationId\":20,\"stationName\":\"ANDROID1\",\"waiterNumber\":3,\"numberOfBills\":0,\"guests\":8,\"tag\":\"\",\"totalIncludingTaxes\":83800,\"maxPaymentLineNumber\":0,\"customer\":null,\"busyGrouping\":{\"nextCount\":5,\"callCount\":2,\"alert\":true}}]"

        val typeToken = object: TypeToken<List<PtxBillListItem>>() {}.type

        return Gson().fromJson<List<PtxBillListItem>>(json, typeToken).toNotes()
    }

    private fun List<PtxBillListItem>.toNotes(): ArrayList<Note> {
        val list: ArrayList<Note> = arrayListOf()

        this.forEach {
            list.add(it.toNote())
        }

        return list
    }
}