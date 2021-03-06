package com.oxsoft.xi

/**
 * http://www.venus.dti.ne.jp/~manabe-a/xi/
 */
@Suppress("unused")
object Stage {
    // 16 step
    val AAA = State(listOf(
            Dice(4, 6, 0, 0),
            Dice(2, 6, 3, 0),
            Dice(1, 3, 1, 1),
            Dice(4, 6, 1, 2),
            Dice(5, 4, 2, 2),
            Dice(1, 2, 2, 3)
    ), 1, 1)

    // 10 step
    val AAB = State(listOf(
            Dice(5, 4, 3, 0),
            Dice(3, 5, 0, 1),
            Dice(2, 4, 3, 1),
            Dice(6, 4, 0, 2),
            Dice(5, 6, 0, 3),
            Dice(5, 6, 3, 3)
    ), 3, 3)

    // 13 step
    val AAC = State(listOf(
            Dice(2, 1, 1, 0),
            Dice(6, 2, 0, 1),
            Dice(1, 2, 2, 1),
            Dice(1, 4, 0, 2),
            Dice(6, 4, 1, 2),
            Dice(2, 3, 3, 2)
    ), 1, 2)

    // 12 step
    val AAD = State(listOf(
            Dice(4, 5, 1, 0),
            Dice(2, 1, 2, 0),
            Dice(4, 6, 3, 0),
            Dice(4, 5, 1, 1),
            Dice(2, 6, 1, 2),
            Dice(6, 5, 2, 2)
    ), 1, 1)

    // 16 step
    val AAE = State(listOf(
            Dice(2, 1, 0, 0),
            Dice(3, 2, 0, 1),
            Dice(3, 2, 0, 2),
            Dice(4, 2, 1, 3),
            Dice(6, 5, 2, 3),
            Dice(2, 1, 3, 3)
    ), 3, 3)

    // 12 step
    val AAF = State(listOf(
            Dice(3, 5, 1, 1),
            Dice(2, 4, 2, 1),
            Dice(4, 1, 0, 2),
            Dice(5, 1, 2, 2),
            Dice(3, 6, 0, 3),
            Dice(2, 4, 1, 3)
    ), 2, 2)

    // 12 step
    val CCB = State(listOf(
            Dice(6, 2, 1, 0),
            Dice(6, 2, 2, 0),
            Dice(6, 4, 3, 0),
            Dice(2, 3, 2, 1),
            Dice(4, 6, 0, 3),
            Dice(2, 1, 2, 3)
    ), 2, 3)

    // 8 step
    val GBI = State(listOf(
            Dice(1, 4, 2, 1),
            Dice(4, 1, 3, 1),
            Dice(6, 5, 0, 2),
            Dice(6, 5, 1, 2),
            Dice(6, 2, 2, 2),
            Dice(4, 6, 3, 3)
    ), 0, 2)
}
