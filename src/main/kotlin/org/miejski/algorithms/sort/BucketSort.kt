package org.miejski.algorithms.sort

import java.math.BigInteger
import java.util.*

class BucketSort : Sort {
    override fun sort(data: Array<Int>): Array<Int> {
        val bigInts = data.map { BigInteger(it.toString()) }
        val min = bigInts.min()!!

        val n = data.size
        val a = (0..n).map { ArrayList<BigInteger>() }


        val map: List<BigInteger> = if (min < BigInteger.ZERO) bigInts.map { it.add(min.abs()) } else bigInts
        val max = map.max()!!
        map.forEach {  x ->
            a[x.multiply(BigInteger(n.toString())).divide(max).toInt()].add(x)
        }

        val result = a.flatMap { it.sorted() }

        if (min.toInt() < 0) {
            return result.map { it.subtract(min.abs())}.map { it.toInt() }.toTypedArray()
        } else return result.map { it.toInt() }.toTypedArray()
    }
}