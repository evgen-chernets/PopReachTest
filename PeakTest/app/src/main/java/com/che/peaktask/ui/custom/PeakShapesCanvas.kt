package com.che.peaktask.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.che.peaktask.R
import com.che.peaktask.usecase.PeakShape

class PeakShapesCanvas @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    fun drawShapes(shapes: List<PeakShape>,  listener: OnClickListener, longListener: OnLongClickListener){
        removeAllViews()
        for ((i, shape) in shapes.withIndex() ) {
            val view = ImageView(context)
            val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            params.setMargins(shape.x, shape.y, 0, 0)
            view.layoutParams = params
            view.z = i.toFloat()
            view.setOnClickListener(listener)
            view.setOnLongClickListener(longListener)
            when (shape.shapeType) {
                PeakShape.Type.Circle -> view.setImageDrawable(context.getDrawable(R.drawable.ic_circle))
                PeakShape.Type.Square -> view.setImageDrawable(context.getDrawable(R.drawable.ic_square))
                PeakShape.Type.Triangle -> view.setImageDrawable(context.getDrawable(R.drawable.ic_triangle))
            }
            addView(view)
        }
        requestLayout()
    }

}