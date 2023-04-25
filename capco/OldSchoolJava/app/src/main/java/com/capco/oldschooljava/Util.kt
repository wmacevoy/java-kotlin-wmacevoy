package com.capco.oldschooljava

object Util {
    fun defaultValue(x: Int?, defX: Int? = 0): Int {
        return x ?: (defX ?: 0)
    }
}