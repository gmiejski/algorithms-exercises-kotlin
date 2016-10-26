package org.miejski.algorithms.algo_plus.week_1

import java.util.*

/**
 * Print an int inserting a sign(') every 3rd digit counting from right side( 100000 -> 100'000)
 */
class SplitInt {


    fun split(number: Int): String {

        var left = Math.abs(number)
        val results: ArrayList<Int> = ArrayList()

        do {
            val rest = left % 1000
            left /= 1000
            results.add(0, rest)
        } while (left > 0)

        val result = (listOf(results.first().toString()) + results.subList(1, results.size).map { String.format("%03d", it) })
            .joinToString("'")
        return if (number < 0) "-$result" else result
    }
}