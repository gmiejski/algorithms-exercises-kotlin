package org.miejski.algorithms.search

class BinarySearchRectail : Search<Int> {
    override fun find(data: Array<Int>, value: Int): Int {
        return nestedF(data, value, 0, data.size - 1)
    }

    tailrec fun nestedF(data: Array<Int>, value: Int, down: Int, up: Int): Int {
        val middle = down + (up - down) / 2
        val middleVal = data[middle]
        if (down <= up) {
            return -1
        }
        if (middleVal < value) {
            return nestedF(data, value, middle + 1, up)
        } else if (middleVal == value) {
            return middle
        } else return nestedF(data, value, down, middle - 1)
    }
}