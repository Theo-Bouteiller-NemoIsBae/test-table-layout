package com.nemoisbae.plantsalletest.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.opengl.Visibility
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.view.forEach
import com.nemoisbae.plantsalletest.data.Struc
import com.nemoisbae.plantsalletest.data.Type
import com.nemoisbae.plantsalletest.model.Note
import com.nemoisbae.plantsalletest.ui.objectbuilder.ObjectBuilder
import com.nemoisbae.plantsalletest.ui.objectbuilder.implementation.FlowerBuilder
import com.nemoisbae.plantsalletest.ui.objectbuilder.implementation.TableBuilder
import com.nemoisbae.plantsalletest.ui.objectbuilder.implementation.WallBuilder
import com.nemoisbae.plantsalletest.ui.widget.Generic
import com.nemoisbae.plantsalletest.ui.widget.Widget
import com.nemoisbae.plantsalletest.ui.widget.implementation.TableWidget
import kotlin.math.roundToInt

class PlanDeSalle(context: Context, private val screenWidth: Int, private val screenHeight: Int, val needRefresh: ()->(ArrayList<Note>)): RelativeLayout(context) {


//    private val datas: ArrayList<ObjectBuilder> = arrayListOf()
    private val datas: ArrayList<Widget> = arrayListOf()

    private val ORIGIN_WIDTH: Float = 3000f
    private val ORIGIN_HEIGHT: Float = 1687f

    private val widthScalingRation: Float = ORIGIN_WIDTH / screenWidth
    private val heightScalingRation: Float = ORIGIN_HEIGHT / screenHeight

    private val layers: MutableMap<Int, ImageView> = mutableMapOf()

    private val backgroundLayer: ImageView = ImageView(context)
    private val tableLayer: ImageView = ImageView(context)
    private val decoratLayer: ImageView = ImageView(context)
    private val alertLayer: ImageView = ImageView(context)

    fun setData(strucs: ArrayList<Struc>) {
        datas.clear()

        strucs.forEach { struc ->

            datas.add(
//                when (struc.type) {
//                    Type.WALL -> WallBuilder(struc, 0)
//                    Type.TABLE -> TableBuilder(struc, 0)
//                    Type.FLOWER -> FlowerBuilder(struc, 0)
//                }
                TableWidget(struc, widthScalingRation, heightScalingRation, context)
            )
        }
        doPopulate()
        runTimer()
        runAutoRefresh()
        postInvalidate()
//        doDraw()
    }

    val mainHandler = Handler(Looper.getMainLooper())
    val autoRefreshHandler = Handler(Looper.getMainLooper())
    val autoRefreshTimeoutInMs: Long = 10000

    private fun runTimer() {
        mainHandler.post(object : Runnable {
            override fun run() {
                datas.filter { it.struc.type == Type.TABLE }.forEach { (it as TableWidget).timeUpdate() }
                mainHandler.postDelayed(this, 1000)
            }
        })
    }

    private fun runAutoRefresh() {
        autoRefreshHandler.post(object : Runnable {
            override fun run() {
                refreshTable(needRefresh())
                Toast.makeText(context, "REFRESH", Toast.LENGTH_SHORT).show()
                mainHandler.postDelayed(this, autoRefreshTimeoutInMs)
            }
        })
    }

    fun refreshTable(notes: ArrayList<Note>) {
        datas.filter { it.struc.type == Type.TABLE }.forEach { widget: Widget ->
            notes.forEach noteForEach@{ note ->
                (widget as TableWidget).let { tableWidget ->
                    if (tableWidget.getTableName() == note.groupingDisplay) {
                        tableWidget.refreshData(note)
                        return@noteForEach
                    }
                }

            }
        }

        postInvalidate()
    }

    private fun doPopulate() {
        datas.forEach {
            this.addView(it, it.getLayoutParamsForAdd())

            it.struc.getRecF(widthScalingRation, heightScalingRation).let { rectF ->
//                this.addView(
//                    it.getView(context, widthScalingRation, heightScalingRation)
//                        .first().layout.apply {
//                        this.x = rectF.left
//                        this.y = rectF.top
//                    }, ViewGroup.LayoutParams(
//                        (rectF.right - rectF.left).roundToInt(),
//                        (rectF.bottom - rectF.top).roundToInt()
//                    ))
            }
        }
    }

    fun changeLayerVisibility(visibility: Int, layer: Int): Boolean {
        if (layers.containsKey(layer).not()) {
            return false
        }

        layers[layer]!!.visibility = visibility

        return true
    }

    private fun doDraw() {
        post {
//            placeBitmapOnImageView(getLayer())
        }
    }

//    private fun getLayer(): MutableMap<Int, Bitmap> {
//        val w: Int = screenWidth.toInt()
//        val h: Int = screenHeight.toInt()
//
//        val layerBitmap: MutableMap<Int, Bitmap> = mutableMapOf()
//        val layerCanvas: MutableMap<Int, Canvas> = mutableMapOf()
//
//        val conf = Bitmap.Config.ARGB_8888 // see other conf types
//
//        layerBitmap[0] = Bitmap.createBitmap(w, h, conf).apply {
//            this.eraseColor(Color.WHITE)
//            layerCanvas[0] = Canvas(this)
//        }
//
//        datas.forEach { objectBuilder ->
//            println("check\r\n")
//            objectBuilder.getDraw(context, widthScalingRation, heightScalingRation).forEachIndexed { index, drawData ->
//                if (layerBitmap.containsKey(drawData.layer).not()) {
//                    println("layer not found create bitmap for ${drawData.layer}\r\n")
//                    layerBitmap[drawData.layer] = Bitmap.createBitmap(w, h, conf).apply {
//                        this.eraseColor(Color.TRANSPARENT)
//                        layerCanvas[drawData.layer] = Canvas(this)
//                    }
//                }
//
//                println("draw a ${objectBuilder.struc.type.name}[$index] at ${drawData.rectf} on ${drawData.layer}\r\n")
//                layerCanvas[drawData.layer]!!.drawBitmap(drawData.bitmap, null, drawData.rectf, null)
//            }
//        }

//        layerCanvas[3]!!.drawRect(RectF(0f, 0f, 50f, 50f), Paint().apply {
//            this.strokeWidth = 5F
//            this.style = Paint.Style.FILL
//            this.isAntiAlias = true
//            this.isDither = true
//            this.color = Color.YELLOW
//        })

//        return layerBitmap
//    }

    private fun placeBitmapOnImageView(layerBitmap: MutableMap<Int, Bitmap>) {
        layers.clear()

        layerBitmap.toSortedMap().forEach { (layer, bitmap) ->
            println("Create display for layer $layer\n\r")
            layers[layer] = ImageView(context).apply { this.setImageDrawable(BitmapDrawable(resources, bitmap)) }
        }

        populate()
    }

    private fun populate() {
        this.removeAllViews()
        layers.forEach { layer, imageView ->
            this.addView(imageView)
        }
    }
}