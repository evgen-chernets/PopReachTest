package com.che.peaktask

import com.che.peaktask.model.PeakShape
import com.che.peaktask.model.ShapeController
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ShapeControllerUnitTest {

    private val shapeController = ShapeController()

    @Test
    fun setBoundsCheck() {
        shapeController.clear()
        shapeController.setBounds(500,500)
        shapeController.addShape(PeakShape.Type.Triangle)
        val shape = shapeController.shapes.last()
        assertEquals(false, shape.x < 500)
        assertEquals(false, shape.y < 500)
    }

    @Test
    fun addCircleCheck() {
        shapeController.clear()
        shapeController.addShape(PeakShape.Type.Circle)
        val shape = shapeController.shapes.last()
        assertEquals(PeakShape.Type.Circle, shape.shapeType)
    }

    @Test
    fun addSquareCheck() {
        shapeController.clear()
        shapeController.addShape(PeakShape.Type.Square)
        val shape = shapeController.shapes.last()
        assertEquals(PeakShape.Type.Square, shape.shapeType)
    }

    @Test
    fun addTriangleCheck() {
        shapeController.clear()
        shapeController.addShape(PeakShape.Type.Triangle)
        val shape = shapeController.shapes.last()
        assertEquals(PeakShape.Type.Triangle, shape.shapeType)
    }

    @Test
    fun deleteShapeCheck() {
        shapeController.clear()
        shapeController.addShape(PeakShape.Type.Triangle)
        assertEquals(1, shapeController.shapes.size)
        shapeController.deleteShape(0)
        assertEquals(0, shapeController.shapes.size)
    }

//    @Test
//    fun call_1_isCorrect() {
//        shapeController.clear()
//        shapeController.deleteShapes()
//        shapeController.transformShape()
//        shapeController.undo()
//    }
}