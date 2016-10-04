package org.miejski.algorithms.search

interface Search<T> {

    fun find(data: Array<T>, value: T): Int
}