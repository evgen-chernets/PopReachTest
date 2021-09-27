package com.che.peaktest.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.che.peaktest.usecase.PeakShape
import com.che.peaktest.usecase.ShapeController

class HomeViewModel: ViewModel() {

    private var shapeController: ShapeController? = null

    fun initController(maxX: Int, maxY: Int) {
        shapeController = ShapeController(maxX, maxY)
    }

    val shapesData = MutableLiveData<List<PeakShape>>().apply {
        value = shapeController!!.shapes
    }

    fun onDrawSquareClicked() {
        shapeController!!.addSquare()
    }

    fun onDrawCircleClicked() {
        shapeController!!.addCircle()
    }

    fun onDrawTriangleClicked() {
        shapeController!!.addTriangle()
    }

    fun onUndoClicked() {
        shapeController!!.undo()
    }

    fun onShapeClicked() {//todo
        shapeController!!.transformShape(0)
    }

    fun onShapeLongTap() {//todo
        shapeController!!.deleteShape(0)
    }
}