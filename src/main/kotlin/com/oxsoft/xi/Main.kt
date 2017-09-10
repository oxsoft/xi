package com.oxsoft.xi

import java.util.*

object Main {
    @JvmStatic
    fun main(vararg args: String) {
        breadthFirstSearch(Stage.AAC)
    }

    private fun breadthFirstSearch(stage: State) {
        val queue: Queue<State> = LinkedList(listOf(stage))
        var step = -1
        while (true) {
            val state = queue.remove()
            if (state.step > step) {
                step = state.step
                println("step $step (${queue.size + 1})")
            }
            val nextStates = state.getNextStates()
            val answer = nextStates.find { it.calcVanishNumber() == 6 }
            if (answer != null) {
                println(answer.toHistory().joinToString("\n\n"))
                break
            }
            if (state.step == 20) continue
            queue.addAll(nextStates.filter { it.calcVanishNumber() == null })
        }
    }
}
