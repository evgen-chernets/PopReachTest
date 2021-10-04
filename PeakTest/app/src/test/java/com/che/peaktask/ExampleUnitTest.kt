package com.che.peaktask

import com.che.peaktask.model.ShapeController
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ShapeControllerUnitTest {
    val shapeController = ShapeController()
    @Test
    fun addition_isCorrect() {
        shapeController.clear()
        assertEquals(4, 2 + 2)
    }
}