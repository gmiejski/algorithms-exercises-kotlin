package org.miejski.algorithms.sort

import org.miejski.structures.BinaryHeap
import java.util.*

class HeapSort : Sort{
    override fun sort(data: Array<Int>): Array<Int> {
        val sorted = ArrayList<Int>(data.size)
        val bf = BinaryHeap.createWithHeapify(data)
        for( i in data.size-1 downTo 0) {
            sorted.add(bf.extract())
        }

        for ( x in sorted) {
            println(x)
        }

        return sorted.toTypedArray().reversedArray()
    }
}