package com.oxsoft.xi

import org.junit.Assert
import org.junit.Test

class PipTest {
    @Test
    fun testOpposite() {
        Pip.values().forEach {
            Assert.assertEquals(it, it.opposite.opposite)
        }
    }

    @Test
    fun testVector() {
        Pip.values().forEach {
            val v = it.vector
            val ov = it.opposite.vector
            Assert.assertEquals(v.first, -ov.first)
            Assert.assertEquals(v.second, -ov.second)
            Assert.assertEquals(v.third, -ov.third)
        }
    }
}
