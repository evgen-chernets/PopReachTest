package com.che.peaktask.model

class PeakEvent(val type: Type, val shape: PeakShape) {

    enum class Type {
        Add, Transform, Delete
    }
}