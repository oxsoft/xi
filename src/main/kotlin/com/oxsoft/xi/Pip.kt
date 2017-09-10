package com.oxsoft.xi

enum class Pip(val value: Int) {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

    val opposite: Pip
        get() = when (this) {
            ONE -> SIX
            TWO -> FIVE
            THREE -> FOUR
            FOUR -> THREE
            FIVE -> TWO
            SIX -> ONE
        }

    val vector: Triple<Int, Int, Int>
        get() = when (this) {
            ONE -> Triple(1, 0, 0)
            TWO -> Triple(0, 1, 0)
            THREE -> Triple(0, 0, 1)
            FOUR -> Triple(0, 0, -1)
            FIVE -> Triple(0, -1, 0)
            SIX -> Triple(-1, 0, 0)
        }
}
