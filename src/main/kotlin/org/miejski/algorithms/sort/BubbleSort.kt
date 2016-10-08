package org.miejski.algorithms.sort

class BubbleSort : Sort {
    override fun sort(data: Array<Int>): Array<Int> {
        var swapped = true
        for (i in (0..data.size - 1)) {

            if (!swapped) {
                break
            }
            swapped = false
            for (j in (0..data.size - 2)) {
                if (data[j] > data[j + 1]) {
                    swapped = true
                    val temp = data[j]
                    data[j] = data[j + 1]
                    data[j + 1] = temp
                }
            }
        }
        return data
    }
}