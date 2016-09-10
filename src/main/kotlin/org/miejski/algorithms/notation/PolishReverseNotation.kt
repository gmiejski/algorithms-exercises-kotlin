package org.miejski.algorithms.notation

class PolishReverseNotation {

    val operations: List<String> = listOf("+", "-", "*", "/", "(", ")")

    fun toReversePolishNotation(sentence: String): List<String> {

        var currentIndex = 0
        while (currentIndex < sentence.length) {
            var firstPart: List<String>
            if (sentence[currentIndex].equals('(')) {
                val firstPartEndIndex = sentenceEndIndex(sentence, currentIndex)
                firstPart = toReversePolishNotation(sentence.substring(1, firstPartEndIndex ))
                currentIndex = firstPartEndIndex + 1

            } else {
                var firstPartEndIndex = operatorEndIndex(sentence, currentIndex)
                firstPart = listOf(sentence.substring(currentIndex, firstPartEndIndex))
                currentIndex = firstPartEndIndex
            }
            if ( currentIndex >= sentence.length) {
                return firstPart
            }
            var operator: List<String> = listOf(sentence[currentIndex].toString())
            return firstPart  + toReversePolishNotation(sentence.substring(currentIndex+1)) + operator
        }
        return listOf()
    }

    private fun operatorEndIndex(sentence: String, x: Int): Int {
        val pair = sentence.findAnyOf(operations)
        when (pair) {
            null -> return sentence.length
            else -> return pair.first
        }
    }

    fun sentenceEndIndex(sentence: String, x: Int): Int {
        var currEndInd = 0
        var currOpenedBraces = 1

        while (currOpenedBraces > 0) {
            currEndInd++
            when (sentence[currEndInd]) {
                '(' -> currOpenedBraces++
                ')' -> currOpenedBraces--
            }
        }
        return currEndInd
    }
}