package com.che.peaktest.usecase

class PeakEvent(val index: Int, val type: Type) {

    enum class Type {
        Add, Transform
    }
}