package com.che.peaktest.usecase

import kotlin.collections.ArrayList

class ShapeController(private val maxX: Int, private val maxY: Int) {
    private var event: PeakEvent? = null
     val shapes = ArrayList<PeakShape>()

    fun addCircle() {
        shapes.add(PeakShape(PeakShape.Type.Circle, getRandomX(),getRandomY()))
        event = PeakEvent(shapes.size - 1, PeakEvent.Type.Add)
    }

    fun addSquare() {
        shapes.add(PeakShape(PeakShape.Type.Square, getRandomX(),getRandomY()))
        event = PeakEvent(shapes.size - 1, PeakEvent.Type.Add)
    }

    fun addTriangle() {
        shapes.add(PeakShape(PeakShape.Type.Triangle, getRandomX(),getRandomY()))
        event = PeakEvent(shapes.size - 1, PeakEvent.Type.Add)
    }

    fun transformShape(index: Int) {
        shapes[index].transform()
        event = PeakEvent(index, PeakEvent.Type.Transform)
    }

    fun deleteShape(index: Int) {
        shapes.removeAt(index)
    }

    fun deleteAll() {
        shapes.clear()
        event = null
    }

    fun undo() {
        when (event?.type) {
            PeakEvent.Type.Add -> {
                shapes.removeAt(event!!.index)
            }
            PeakEvent.Type.Transform -> {
                shapes[event!!.index].reverseTransform()
            }
        }
    }

    private fun getRandomX(): Int {
        return (maxX * Math.random()).toInt()
    }

    private fun getRandomY(): Int {
        return (maxY * Math.random()).toInt()
    }
}