package com.che.peaktask.model

class PeakEvent(val index: Int, val type: Type) {

    enum class Type {
        Add, Transform
    }
}