package com.oxsoft.xi

data class Dice(val top: Pip, val back: Pip, val x: Int, val y: Int) {
    constructor(top: Int, back: Int, x: Int, y: Int) : this(Pip.values().find { it.value == top }.guard { IllegalArgumentException() }, Pip.values().find { it.value == back }.guard { IllegalArgumentException() }, x, y)

    init {
        if (top == back) throw IllegalArgumentException("top and back are same")
        if (top == back.opposite) throw IllegalArgumentException("top and back are opposite")
    }

    val bottom get() = top.opposite
    val front get() = back.opposite
    val left get() = back op top
    val right get() = top op back

    fun moveTo(direction: Direction) = when (direction) {
        Direction.LEFT -> moveToLeft()
        Direction.UP -> moveToFront()
        Direction.RIGHT -> moveToRight()
        Direction.DOWN -> moveToBack()
    }

    fun moveToFront(): Dice = Dice(back, bottom, x, y - 1)
    fun moveToBack(): Dice = Dice(front, top, x, y + 1)
    fun moveToLeft(): Dice = Dice(right, back, x - 1, y)
    fun moveToRight(): Dice = Dice(left, back, x + 1, y)

    private infix fun Pip.op(other: Pip) = (this.vector op other.vector).let { v -> Pip.values().find { it.vector == v } }.guard { IllegalArgumentException() }

    private infix fun Triple<Int, Int, Int>.op(other: Triple<Int, Int, Int>) = Triple(
            second * other.third - third * other.second,
            third * other.first - first * other.third,
            first * other.second - second * other.first
    )

    override fun toString(): String = "top = ${top.value}, back = ${back.value}, right = ${right.value}, pos = ($x, $y)"
}
