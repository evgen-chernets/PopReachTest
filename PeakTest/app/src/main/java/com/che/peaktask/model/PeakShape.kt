package com.che.peaktask.model

class PeakShape(val id: Long, var shapeType: Type, val x: Int, val y: Int) {
    fun transform() {
        shapeType = when(shapeType) {
            Type.Circle -> Type.Triangle
            Type.Square -> Type.Circle
            Type.Triangle -> Type.Square
        }
    }

    fun reverseTransform() {
        shapeType = when(shapeType) {
            Type.Circle -> Type.Square
            Type.Square -> Type.Triangle
            Type.Triangle -> Type.Circle
        }
    }

    enum class Type { Circle, Square, Triangle }
}