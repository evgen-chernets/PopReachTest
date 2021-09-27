package com.che.peaktask.usecase

class PeakEvent(val index: Int, val type: Type) {

    enum class Type {
        Add, Transform
    }
}