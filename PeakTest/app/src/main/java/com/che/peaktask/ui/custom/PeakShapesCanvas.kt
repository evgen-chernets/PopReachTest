package com.che.peaktest.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.che.peaktest.R
import com.che.peaktest.usecase.PeakShape

class PeakShapesCanvas @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    fun drawShapes(shapes: List<PeakShape>){
        removeAllViews()
        for (shape in shapes) {
            val view = ImageView(context)
            when (shape.shapeType) {
                PeakShape.Type.Circle -> view.setImageDrawable(context.getDrawable(R.drawable.ic_circle))
                PeakShape.Type.Square -> view.setImageDrawable(context.getDrawable(R.drawable.ic_square))
                PeakShape.Type.Triangle -> view.setImageDrawable(context.getDrawable(R.drawable.ic_triangle))
            }
            view.top = shape.x
            view.left = shape.y
            addView(view)
        }
    }

}