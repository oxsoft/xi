package com.oxsoft.xi

import org.junit.Assert
import org.junit.Test

class StateTest {
    @Test(expected = IllegalArgumentException::class)
    fun testInitWithNotOnDice() {
        State(listOf(Dice(1, 2, 0, 0)), 1, 1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInitWithOutOfBounds() {
        State(listOf(Dice(1, 2, -1, 0)), -1, 0)
    }

    @Test
    fun testGetNextStates() {
        val dice = Dice(1, 2, 0, 0)
        val state = State(listOf(dice), 0, 0)
        val nextStates = state.getNextStates()
        Assert.assertEquals(2, nextStates.size)
        nextStates.forEach {
            Assert.assertEquals(1, it.step)
            Assert.assertEquals(1, it.dices.size)
            when {
                it.x == 1 && it.y == 0 -> Assert.assertEquals(dice.moveToRight(), it.dices[0])
                it.x == 0 && it.y == 1 -> Assert.assertEquals(dice.moveToBack(), it.dices[0])
                else -> Assert.fail()
            }
        }
    }

    @Test
    fun testCalcVanishNumber() {
        val dice1 = Dice(1, 2, 0, 0)
        val dice2 = Dice(2, 3, 0, 0)
        val dice3 = Dice(3, 1, 0, 0)
        val dice6 = Dice(6, 4, 0, 0)
        Assert.assertEquals(null, State(listOf(dice1), 0, 0).calcVanishNumber())
        Assert.assertEquals(2, State(listOf(dice2, dice2.copy(x = 1)), 0, 0).calcVanishNumber())
        Assert.assertEquals(null, State(listOf(dice2, dice2.copy(x = 2)), 0, 0).calcVanishNumber())
        Assert.assertEquals(null, State(listOf(dice3, dice3.copy(x = 1)), 0, 0).calcVanishNumber())
        Assert.assertEquals(6, State(listOf(dice6, dice6.copy(x = 1), dice6.copy(y = 1), dice6.copy(x = 1, y = 1), dice6.copy(x = 2), dice6.copy(y = 2)), 0, 0).calcVanishNumber())
    }
}
