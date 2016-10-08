package org.miejski.algorithms.sort

class MergeSort : Sort {
    override fun sort(data: Array<Int>): Array<Int> {
        return mergeSort(data, 0, data.size-1)
    }

    fun mergeSort(data: Array<Int>, l: Int, r: Int): Array<Int> {
        if ( l == r) {
            return arrayOf(data[l])
        }
        val middle = (l + r) / 2
        val leftSortedPart = mergeSort(data, l, middle)
        val rightSortedPart = mergeSort(data, middle + 1, r)
        return merge(leftSortedPart, rightSortedPart)
    }

    private fun merge(leftSortedPart: Array<Int>, rightSortedPart: Array<Int>): Array<Int> {
        val leftPartSize = leftSortedPart.size
        val rightPartSize = rightSortedPart.size
        val resultingArray = Array(leftPartSize + rightPartSize) { 0 }
        var resultingArrayPointer = 0
        var leftIndex = 0
        var rightIndex = 0
        while (leftIndex < leftPartSize && rightIndex < rightPartSize) {
            if (leftSortedPart[leftIndex] < rightSortedPart[rightIndex]) {
                resultingArray[resultingArrayPointer++] = leftSortedPart[leftIndex++]
            } else {
                resultingArray[resultingArrayPointer++] = rightSortedPart[rightIndex++]
            }
        }
        while (leftIndex < leftPartSize) {
            resultingArray[resultingArrayPointer++] = leftSortedPart[leftIndex++]
        }
        while (rightIndex < rightPartSize) {
            resultingArray[resultingArrayPointer++] = rightSortedPart[rightIndex++]
        }

        return resultingArray
    }
}