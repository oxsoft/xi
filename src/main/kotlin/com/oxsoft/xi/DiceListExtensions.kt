package com.oxsoft.xi

fun List<Dice>.toField(width: Int, height: Int): List<List<Dice?>> {
    val field = (0 until height).map { (0 until width).map { null }.toMutableList<Dice?>() }
    this.forEach { field[it.y][it.x] = it }
    return field
}

fun List<Dice>.calcReachableDices(x: Int, y: Int): Set<Dice> {
    val dice = this.find { it.x == x && it.y == y } ?: throw IllegalArgumentException()
    val remain = this.toMutableSet().also { it.remove(dice) }
    val reachableDices = mutableSetOf(dice)
    val stack = mutableListOf<Dice>(dice)
    while (stack.isNotEmpty()) {
        val current = stack.removeAt(stack.size - 1)
        val neighbor = remain.filter { Math.abs(current.x - it.x) + Math.abs(current.y - it.y) <= 1 }
        remain.removeAll(neighbor)
        reachableDices.addAll(neighbor)
        stack.addAll(neighbor)
    }
    return reachableDices
}
