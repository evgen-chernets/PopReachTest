package com.che.peaktask.usecase

import kotlin.collections.ArrayList

class ShapeController() {
    private var maxX = 0
    private var maxY = 0
    private var event: PeakEvent? = null
    val shapes = ArrayList<PeakShape>()

    fun setBounds(x: Int, y: Int) {
        maxX = x
        maxY = y
    }

    fun addCircle() {
        shapes.add(PeakShape(PeakShape.Type.Circle, getRandomX(), getRandomY()))
        event = PeakEvent(shapes.size - 1, PeakEvent.Type.Add)
    }

    fun addSquare() {
        shapes.add(PeakShape(PeakShape.Type.Square, getRandomX(), getRandomY()))
        event = PeakEvent(shapes.size - 1, PeakEvent.Type.Add)
    }

    fun addTriangle() {
        shapes.add(PeakShape(PeakShape.Type.Triangle, getRandomX(), getRandomY()))
        event = PeakEvent(shapes.size - 1, PeakEvent.Type.Add)
    }

    fun transformShape(index: Int) {
        shapes[index].transform()
        event = PeakEvent(index, PeakEvent.Type.Transform)
    }

    fun deleteShape(index: Int) {
        shapes.removeAt(index)
    }

    fun deleteShapes(type: PeakShape.Type) {
        shapes.removeAll{ it.shapeType == type }
    }

    fun undo() {
        if (event != null) {
            when (event!!.type) {
                PeakEvent.Type.Add -> {
                    shapes.removeAt(event!!.index)
                }
                PeakEvent.Type.Transform -> {
                    shapes[event!!.index].reverseTransform()
                }
            }
            event = null
        }
    }

    private fun getRandomX(): Int {
        return (maxX * Math.random()).toInt()
    }

    private fun getRandomY(): Int {
        return (maxY * Math.random()).toInt()
    }
}