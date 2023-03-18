package com.vvwxx.bangkit.myunittest

interface ICuboidModel {
    fun getVolume(): Double
    fun getSurfaceArea(): Double
    fun getCircumference(): Double
    fun save(width: Double, length: Double, height: Double)
}

class CuboidModel : ICuboidModel {
    private var width = 0.0
    private var length = 0.0
    private var height = 0.0

    override fun getVolume(): Double = width * length * height

    override fun getSurfaceArea(): Double {
        val wl = width * length
        val wh = width * height
        val lh = length * height
        return 2 * (wl + wh + lh)
    }

    override fun getCircumference(): Double = 4 * (width + length + height)

    override fun save(width: Double, length: Double, height: Double) {
        this.width = width
        this.length = length
        this.height = height
    }
}