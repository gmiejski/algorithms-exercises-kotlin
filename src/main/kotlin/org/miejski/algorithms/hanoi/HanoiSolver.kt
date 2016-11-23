package org.miejski.algorithms.hanoi

import java.util.*

class HanoiSolver {

    class HanoiStack(val name: String, val stack: Stack<Int>) {

        constructor(name: String) : this(name, Stack<Int>())

        val elements: ArrayList<Int> = ArrayList()

        fun push(item: Int) {
            if (stack.isNotEmpty() && stack.peek() < item) {
                throw RuntimeException("Stack $name: cannot move item $item on top of ${stack.peek()}")
            }
            stack.push(item)
            elements.add(item)
        }

        fun pop(): Int {
            elements.removeAt(elements.size - 1)
            return stack.pop()!!
        }

        override fun toString(): String {
            return elements.toString()
        }

        fun peek(): Int {
            return stack.peek()
        }
    }

    companion object {
        @JvmStatic fun solve(height: Int): List<HanoiStack> {

            val widths = 1..height
            val stacks = listOf(HanoiStack("A"), HanoiStack("B"), HanoiStack("C"))
            widths.reversed().forEach {
                stacks[1].push(it)
            }

            mv(widths.toList(), stacks[1], stacks[2], stacks[0])
            return stacks
        }


        fun mv(items: List<Int>, from: HanoiStack, to: HanoiStack, third: HanoiStack) {
            if (items.size == 1) {
//                println("${from.name} -> ${to.name} : ${from.peek()}")
                to.push(from.pop())
                return
            }
            val prefixed = items.subList(0, items.size - 1)
            mv(prefixed, from, third, to)
            mv(listOf(prefixed.last()), from, to, third)
            mv(prefixed, third, to, from)
        }
    }
}