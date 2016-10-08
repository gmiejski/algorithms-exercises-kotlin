package org.miejski.algorithms.search

class BinarySearch : Search<Int> {
    override fun find(data: Array<Int>, value: Int): Int {
        var up = data.size - 1
        var down = 0

        while (down <= up) {
            val middle = (up + down) / 2
            val middleVal = data[middle]
            when (middleVal.compareTo(value)) {
                0 -> return middle
                -1 -> down = middle + 1
                1 -> up = middle - 1
            }
        }
        return -1
    }

}