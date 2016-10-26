package org.miejski.algorithms.algo_plus.week_1

import java.util.*

/**
 * Find longest common substring in which number of unique characters is M
 * M=3, “axyxzyxyb” -> 7 (“xyxzyxy”)
 */
class LongestCommonSubstringWithMaxUniqueChars {

    data class BestResult(val start: Int, val end: Int) {
        fun length(): Int {
            return end - start
        }
    }

    fun find(input: String, uniqueCount: Int): Int {
        var currentBestResult = BestResult(0, 0)
        var current_start = 0
        var current_end = 0

        val substringLettersCount = HashMap<Char, Int>() // current substring count of each letter
        val substringLettersLastIndex = HashMap<Char, Int>() // current substring last index of already processed letters

        while (current_end < input.length) {
            val currentChar = input[current_end]
            substringLettersCount[currentChar] = substringLettersCount.getOrPut(currentChar, { 0 }) + 1 //

            if (substringLettersCount.filter { it.value > 0 }.size > uniqueCount) {
                if (currentBestResult.length() < BestResult(current_start, current_end).length()) {
                    currentBestResult = BestResult(current_start, current_end)
                }
                val minStartPosition = substringLettersLastIndex.minBy { it.value }
                substringLettersLastIndex.remove(minStartPosition!!.key)

                for (i in (current_start..minStartPosition.value)) {
                    val charToRemove = input[i]
                    substringLettersCount[charToRemove] = substringLettersCount[charToRemove]!! - 1
                }
                current_start = minStartPosition.value + 1
            } else {

            }
            substringLettersLastIndex[currentChar] = current_end
            current_end++
        }
        return currentBestResult.length()
    }
}