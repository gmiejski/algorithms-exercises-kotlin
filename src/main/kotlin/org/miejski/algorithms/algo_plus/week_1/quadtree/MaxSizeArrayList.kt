package org.miejski.algorithms.algo_plus.week_1.quadtree

class MaxSizeArrayList<T>(val list: MutableList<T>, val capacity: Int) : MutableList<T> by list {

    override fun add(element: T): Boolean {
        if (list.size == capacity) {
            throw RuntimeException("MaxSizeArray size exceeded: current size = ${list.size}")
        }
        list.add(element)
        return true
    }

    override fun add(index: Int, element: T) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun addAll(elements: Collection<T>): Boolean {
        throw UnsupportedOperationException("not implemented")
    }
}