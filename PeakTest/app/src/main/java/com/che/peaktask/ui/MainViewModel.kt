package com.che.peaktask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.che.peaktask.model.PeakShape
import com.che.peaktask.model.ShapeController

class MainViewModel: ViewModel() {

    private var shapeController: ShapeController = ShapeController()

    val shapesData = MutableLiveData<List<PeakShape>>().apply {
        value = shapeController.shapes
    }

    fun initController(maxX: Int, maxY: Int) {
        shapeController.setBounds(maxX, maxY)
    }

    fun onDrawSquareClicked() {
        shapeController.addShape(PeakShape.Type.Square)
        shapesData.postValue(shapeController.shapes)
    }

    fun onDrawCircleClicked() {
        shapeController.addShape(PeakShape.Type.Circle)
        shapesData.postValue(shapeController.shapes)
    }

    fun onDrawTriangleClicked() {
        shapeController.addShape(PeakShape.Type.Triangle)
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