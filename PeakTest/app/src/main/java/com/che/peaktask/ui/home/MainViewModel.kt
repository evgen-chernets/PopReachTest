package com.che.peaktask.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.che.peaktask.usecase.PeakShape
import com.che.peaktask.usecase.ShapeController

class MainViewModel: ViewModel() {

    private var shapeController: ShapeController = ShapeController()

    val shapesData = MutableLiveData<List<PeakShape>>().apply {
        value = shapeController.shapes
    }

    fun initController(maxX: Int, maxY: Int) {
        shapeController.setBounds(maxX, maxY)
    }

    fun onDrawSquareClicked() {
        shapeController.addSquare()
        shapesData.postValue(shapeController.shapes)
    }

    fun onDrawCircleClicked() {
        shapeController.addCircle()
        shapesData.postValue(shapeController.shapes)
    }

    fun onDrawTriangleClicked() {
        shapeController.addTriangle()
        shapesData.postValue(shapeController.shapes)
    }

    fun onUndoClicked() {
        shapeController.undo()
        shapesData.postValue(shapeController.shapes)
    }

    fun onShapeClicked(index: Int) {
        shapeController.transformShape(index)
        shapesData.postValue(shapeController.shapes)
    }

    fun onShapeLongClicked(index: Int) {
        shapeController.deleteShape(index)
        shapesData.postValue(shapeController.shapes)
    }

    fun onDeleteSquares() {
        shapeController.deleteShapes(PeakShape.Type.Square)
        shapesData.postValue(shapeController.shapes)
    }

    fun onDeleteCircles() {
        shapeController.deleteShapes(PeakShape.Type.Circle)
        shapesData.postValue(shapeController.shapes)
    }

    fun onDeleteTriangles() {
        shapeController.deleteShapes(PeakShape.Type.Triangle)
        shapesData.postValue(shapeController.shapes)
    }
}