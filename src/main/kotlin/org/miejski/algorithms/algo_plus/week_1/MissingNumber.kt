package org.miejski.algorithms.algo_plus.week_1


/**
 * In sorted list (size N) of ints between [0,N] find the missing number
 */
class MissingNumber {

    fun prepareList(size: Int, without: Int): List<Int> {
        return (0..size).filter { it != without }.toList()
    }

    fun findMissing(input: List<Int>): Int {

        var l = 0
        var r = input.size - 1

        while (l < r) {
            val middle = l + ((r - l) / 2)
            val middleValue = input[middle]
            if (middleValue > middle) {
                r = middle - 1
            } else {
                l = middle + 1
            }
        }
        when (input[l] - l) {
            0 -> return l + 1
            1 -> return l
            else -> return -1
        }
    }
}