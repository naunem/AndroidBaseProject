package com.example.navigationcomponentbaseproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.MotionEvent.INVALID_POINTER_ID
import android.view.ScaleGestureDetector
import android.view.View
import androidx.core.content.ContextCompat
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class CustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.red)
    }
    private val gridPaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.black)
        textSize = 30F
    }
    private val padding = 50F
    private val spacing = 50F
    private val columnCount = 10
    private val data = mutableListOf<Int>().apply {
        (1..columnCount).forEach {
            add(Random.nextInt(it, 100))
        }
    }
    private var scaleFactor = 1F

    private val scaleListener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            scaleFactor *= detector?.scaleFactor ?: 1F

            // Don't let the object get too small or too large.
            scaleFactor = max(0.1F, min(scaleFactor, 5.0F))
            println("xxxxxx onScale: $scaleFactor")
            invalidate()
            return true
        }
    }
    private var activePointerId = INVALID_POINTER_ID
    private var lastTouchX = 0F
    private var lastTouchY = 0F
    private var posX = 0F
    private var posY = 0F

    private val scaleDetector = ScaleGestureDetector(context, scaleListener)

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // Let the ScaleGestureDetector inspect all events.
        scaleDetector.onTouchEvent(event)

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                event.actionIndex.let { pointerIndex ->
                    // Remember where we started (for dragging)
                    lastTouchX = event.getX(pointerIndex)
                    lastTouchY = event.getY(pointerIndex)
                }
                // Save the ID of this pointer (for dragging)
                activePointerId = event.getPointerId(0)
                println("xxxxxx onTouchEvent: ACTION_DOWN")
            }
            MotionEvent.ACTION_MOVE -> {
                // Find the index of the active pointer and fetch its position
//                val (x: Float, y: Float) = event.findPointerIndex(activePointerId).let { pointerIndex ->
//                    // Calculate the distance moved
//                    event.getX(pointerIndex) to event.getY(pointerIndex)
//                }
//                posX += x - lastTouchX
//                posY += y - lastTouchY

                posX = event.x
                posY = event.y
                println("xxxxxx onTouchEvent: ACTION_MOVE : ${event.x} : ${event.y}")
                invalidate()

                // Remember this touch position the next move event
                lastTouchX = x
                lastTouchY = y
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                println("xxxxxx onTouchEvent: ACTION_UP")
                activePointerId = INVALID_POINTER_ID
            }
            MotionEvent.ACTION_POINTER_UP -> {
                println("xxxxxx onTouchEvent: ACTION_POINTER_UP")
                event.actionIndex.also { pointerIndex ->
                    event.getPointerId(pointerIndex)
                            .takeIf { it == activePointerId }
                            ?.run {
                                // This was our active pointer going up. Choose a new
                                // active pointer and adjust accordingly.
                                val newPointerIndex = if (pointerIndex == 0) 1 else 0
                                lastTouchX = event.getX(newPointerIndex)
                                lastTouchY = event.getY(newPointerIndex)
                                activePointerId = event.getPointerId(newPointerIndex)
                            }
                }
            }
        }
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val gridLeft = padding
        val gridBottom = height - padding
        val gridTop = padding
        val gridRight = width - padding
        val gridHeight = gridBottom - gridTop

        val totalColumnSpacing = spacing * (columnCount + 1)
        val columnWidth = (gridRight - gridLeft - totalColumnSpacing) / columnCount
        var columnLeft = gridLeft + spacing
        var columnRight = columnLeft + columnWidth

        val guideLineSpacing = (gridBottom - gridTop) / 10F
        canvas?.run {
            // draw grid view
            drawLine(gridLeft, gridBottom, gridLeft, gridTop, gridPaint)
            drawLine(gridLeft, gridBottom, gridRight, gridBottom, gridPaint)

            (0..10).forEach {
                val y = gridBottom - it * guideLineSpacing
                drawLine(gridLeft, y, gridRight, y, gridPaint)
                drawText(it.toString(), gridLeft - 30F, y, gridPaint)
            }

            save()
//            scale(scaleFactor, scaleFactor)


            data.forEach {
                val top = gridTop + gridHeight * (1f - it / 100F)
                drawRect(columnLeft, top, columnRight, gridBottom, paint)

                columnLeft = columnRight + spacing
                columnRight = columnLeft + columnWidth
            }

            translate(posX, posY)

            restore()
        }
    }
}
