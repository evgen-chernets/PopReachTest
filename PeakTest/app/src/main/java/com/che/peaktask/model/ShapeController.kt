package com.che.peaktask.model

import java.util.*
import kotlin.collections.ArrayList
import com.che.peaktask.model.PeakEvent.Type.*

class ShapeController {
    private var maxX = 0
    private var maxY = 0
    private var events = Stack<PeakEvent>()
    val shapes = ArrayList<PeakShape>()

    fun setBounds(x: Int, y: Int) {
        maxX = x
        maxY = y
    }

    fun addShape(type: PeakShape.Type) {
        shapes.add(PeakShape(System.currentTimeMillis(), type, getRandomX(), getRandomY()))
        events.push(PeakEvent(Add, shapes.last()))
    }

    fun transformShape(index: Int) {
        shapes[index].transform()
        events.push(PeakEvent(Transform, shapes[index]))
    }

    fun deleteShape(index: Int) {
        events.push(PeakEvent(Delete, shapes[index]))
        shapes.removeAt(index)
    }

    fun deleteShapes(type: PeakShape.Type) {
        shapes.removeAll { it.shapeType == type }

        val eventsToRemove =
            events.filter { (it.type == Add || it.type == Transform) && it.shape.shapeType == type }
        for (event in eventsToRemove) {
            events.removeAll(events.filter { it.shape.id == event.shape.id })
        }
    }

    fun undo() {
        if (events.isNotEmpty()) {
            val undoEvent = events.pop()
            when (undoEvent.type) {
                Add -> shapes.remove(undoEvent.shape)
                Transform -> undoEvent.shape.reverseTransform()
                Delete -> shapes.add(undoEvent.shape)
            }
        }
    }

    fun clear() {
        maxX = 0
        maxY = 0
        shapes.clear()
        events.clear()
    }

    private fun getRandomX(): Int {
        return (maxX * Math.random()).toInt()
    }

    private fun getRandomY(): Int {
        return (maxY * Math.random()).toInt()
    }
}