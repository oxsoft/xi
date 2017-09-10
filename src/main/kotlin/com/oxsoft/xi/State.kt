package com.oxsoft.xi

data class State(val dices: List<Dice>, val x: Int, val y: Int, val step: Int = 0, private val previous: State? = null) {
    init {
        if (dices.none { it.x == x && it.y == y }) throw IllegalArgumentException("You are on no dice")
        if (dices.any { it.x < 0 || it.x >= WIDTH || it.y < 0 || it.y >= HEIGHT }) throw IllegalArgumentException("Some dices are out of bounds")
        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) throw IllegalArgumentException("You are out of bounds")
    }

    fun getNextStates(): List<State> {
        val field = dices.toField(WIDTH, HEIGHT)
        val reachableDices = dices.calcReachableDices(x, y)
        val nextStates = mutableListOf<State>()
        reachableDices.forEach { dice ->
            Direction.values().forEach { d ->
                val x = dice.x + d.x
                val y = dice.y + d.y
                if (x in 0..(WIDTH - 1) && y in 0..(HEIGHT - 1) && field[y][x] == null) {
                    val nextDices = dices.map {
                        if (it == dice) {
                            it.moveTo(d)
                        } else {
                            it
                        }
                    }
                    if (nextDices != previous?.dices) {
                        nextStates.add(State(nextDices, x, y, step + 1, this))
                    }
                }
            }
        }
        return nextStates
    }

    fun calcVanishNumber(): Int? {
        (2..6).forEach { number ->
            val d = dices.filter { it.top.value == number }
            if (d.size < number) return@forEach
            d.forEach {
                val r = d.calcReachableDices(it.x, it.y)
                if (r.size >= number) return number
            }
        }
        return null
    }

    override fun toString(): String = dices.toField(WIDTH, HEIGHT).joinToString(separator = "\n", transform = { it.joinToString(separator = "", transform = { it?.top?.value?.toString() ?: "." }) })

    fun toHistory(): List<State> {
        val history = mutableListOf(this)
        var state = previous
        while (state != null) {
            history.add(0, state)
            state = state.previous
        }
        return history
    }

    companion object {
        private const val WIDTH = 4
        private const val HEIGHT = 4
    }
}
