package org.miejski.algorithms.sort

class QuickSort : Sort {
    override fun sort(data: Array<Int>): Array<Int> {

        return quicksort(data, 0, data.size - 1)

    }

    private fun quicksort(data: Array<Int>, l: Int, r: Int): Array<Int> {
        if (l < r) {
            val (partitionedData,pivotIndex) = partition(data, l, r)
            val leftSortedPart = quicksort(partitionedData, l, pivotIndex - 1)
            val rightSortedPart = quicksort(partitionedData, pivotIndex + 1, r)
            return mergeResultingArrays(leftSortedPart, partitionedData[pivotIndex], rightSortedPart)
        }
        if ( l > r) {
            return listOf<Int>().toTypedArray()
        }
        return listOf(data[l]).toTypedArray()
    }

    fun partition(data: Array<Int>, l: Int, r: Int): Pair<Array<Int>, Int> {
        val pivotIndex = r
        val pivotValue = data[r]
        var i = l - 1 // i-> index where for every index j<i, data[j] < pivotValue

        for (j in (l..r - 1)) {
            if ( data[j] < pivotValue) {
                i++
                val tmp = data[j]
                data[j] = data[i]
                data[i] = tmp
            }
        }
        val tmp = data[i+1] // data[i+1] is first number with value > pivotValue
        data[i+1] = data[pivotIndex]
        data[pivotIndex] = tmp

        return Pair(data,i+1)
    }

    private fun mergeResultingArrays(leftSortedPart: Array<Int>, pivotValue: Int, rightSortedPart: Array<Int>): Array<Int> {
        val result = Array<Int>(leftSortedPart.size + rightSortedPart.size + 1, { 0 })
        var resultIndex = 0
        for (x in leftSortedPart) {
            result[resultIndex++] = x
        }
        result[resultIndex++] = pivotValue

        for (x in rightSortedPart) {
            result[resultIndex++] = x
        }
        return result
    }
}