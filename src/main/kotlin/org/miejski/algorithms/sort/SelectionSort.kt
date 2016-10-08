package org.miejski.algorithms.sort

class SelectionSort : Sort {
    override fun sort(data: Array<Int>): Array<Int> {

        for (i in (0..data.size - 1)) {

            var nextSmallestValueIndex = i

            for (j in (i + 1..data.size - 1)) {
                if (data[nextSmallestValueIndex] > data[j]) {
                    nextSmallestValueIndex = j
                }
            }
            val temp = data[i]
            data[i] = data[nextSmallestValueIndex]
            data[nextSmallestValueIndex] = temp
        }

        return data
    }
}