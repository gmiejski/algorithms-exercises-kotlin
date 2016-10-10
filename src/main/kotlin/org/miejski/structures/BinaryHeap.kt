package org.miejski.structures

class BinaryHeap(var data: Array<Int>) {

    companion object {
        @JvmStatic fun create(data: Array<Int>): BinaryHeap {
            val bh = BinaryHeap(emptyArray())
            for (x in data) {
                bh.insert(x)
            }
            return bh
        }

        @JvmStatic fun createWithHeapify(data: Array<Int>): BinaryHeap {
            val bh = BinaryHeap(data)
            for (i in data.size / 2 - 1 downTo 0)
                bh.maxHeapify(i)
            return bh
        }
    }

    fun maxHeapify(startingIndex: Int) {
        val leftChildIndex = leftChildIndex(startingIndex)
        val rightChildIndex = rightChildIndex(startingIndex)
        var largestIndex = startingIndex

        if (exists(leftChildIndex) && data[leftChildIndex] > data[largestIndex]) {
            largestIndex = leftChildIndex
        }
        if (exists(rightChildIndex) && data[rightChildIndex] > data[largestIndex]) {
            largestIndex = rightChildIndex
        }

        if (largestIndex != startingIndex) {
            val tmp = data[largestIndex]
            data[largestIndex] = data[startingIndex]
            data[startingIndex] = tmp
            maxHeapify(largestIndex)
        }
    }

    /**
    return root of the Heap
     **/
    fun extract(): Int {
        val rootValue = data[0]
        data[0] = data[data.size-1]
        maxHeapify(0)

        data = data.copyOfRange(0, data.size-1)
        return rootValue
    }

    private fun exists(index: Int): Boolean {
        return index < data.size
    }

    fun insert(x: Int) {
        var newValueIndex = data.size
        data = data.plus(x)
        while (hasParent(newValueIndex) && data[parentIndex(newValueIndex)] < data[newValueIndex]) {
            val tmp = data[parentIndex(newValueIndex)]
            data[parentIndex(newValueIndex)] = data[newValueIndex]
            data[newValueIndex] = tmp
            newValueIndex = parentIndex(newValueIndex)
        }
    }

    private fun hasParent(nodeIndex: Int): Boolean {
        return nodeIndex != 0
    }

    private fun leftChildIndex(parentIndex: Int): Int {
        return 2 * parentIndex + 1
    }

    private fun rightChildIndex(parentIndex: Int): Int {
        return 2 * parentIndex + 2
    }

    private fun parentIndex(index: Int): Int {
        return (index - 1) / 2
    }
}

