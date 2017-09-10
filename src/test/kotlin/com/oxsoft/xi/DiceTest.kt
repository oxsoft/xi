package com.oxsoft.xi

import org.junit.Assert
import org.junit.Test

class DiceTest {
    private val dice = Dice(1, 2, 3, 4)

    @Test(expected = IllegalArgumentException::class)
    fun testInitWithInvalidNumber() {
        Dice(1, 0, 0, 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInitWithSamePip() {
        Dice(1, 1, 0, 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInitWithOppositePip() {
        Dice(1, 6, 0, 0)
    }

    @Test
    fun testMoveToFront() {
        Assert.assertEquals(dice.copy(y = dice.y - 4), dice.moveToFront().moveToFront().moveToFront().moveToFront())
    }

    @Test
    fun testMoveToBack() {
        Assert.assertEquals(dice.copy(y = dice.y + 4), dice.moveToBack().moveToBack().moveToBack().moveToBack())
    }

    @Test
    fun testMoveToLeft() {
        Assert.assertEquals(dice.copy(x = dice.x - 4), dice.moveToLeft().moveToLeft().moveToLeft().moveToLeft())
    }

    @Test
    fun testMoveToRight() {
        Assert.assertEquals(dice.copy(x = dice.x + 4), dice.moveToRight().moveToRight().moveToRight().moveToRight())
    }
}
