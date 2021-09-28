package com.che.peaktask.model

class PeakEvent(val index: Int, val type: Type, val deletedShape: PeakShape? = null) {

    enum class Type {
        Add, Transform, Delete
    }
}