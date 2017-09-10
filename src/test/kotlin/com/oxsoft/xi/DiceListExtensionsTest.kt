package com.oxsoft.xi

import org.junit.Assert
import org.junit.Test

class DiceListExtensionsTest {
    @Test
    fun testToFiled() {
        val dice = Dice(1, 2, 2, 2)
        val field = listOf(dice).toField(4, 4)
        Assert.assertEquals(dice, field[2][2])
        Assert.assertEquals(null, field[0][0])
    }

    @Test
    fun testCalcReachableDices() {
        val dice1 = Dice(1, 2, 0, 0)
        val dice2 = Dice(1, 2, 1, 0)
        val dice3 = Dice(1, 2, 1, 1)
        val dice4 = Dice(1, 2, 2, 2)
        val actual = listOf(dice1, dice2, dice3, dice4).calcReachableDices(0, 0)
        Assert.assertEquals(setOf(dice1, dice2, dice3), actual)
    }
}
