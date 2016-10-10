package org.miejski.algorithms.watertanks


/**
 * input - array of numbers
 * Imagine every number represents a column made of material of height equal to X blocks - value on given index
 * Imagine endless rain that fill empty blocks between columns
 * Result - count how many blocks of water can be hold between all columns
 */
class WaterTanks {

    fun calculateWaterCapacity(data: Array<Int>): Int {
        return maxSizeList(data)
            .zip(maxSizeList(data.reversedArray()).reversedArray())
            .map { Math.min(it.first, it.second) }
            .zip(data)
            .map { it.first - it.second }
            .filter { it > 0 }
            .sum()
    }

    fun maxSizeList(data: Array<Int>): Array<Int> {
        val result = emptyArray<Int>().toMutableList()
        data.mapIndexedTo(result, { index, value -> if (result.isEmpty()) 0 else Math.max(result.last(), data[index - 1]) })
        return result.toTypedArray()
    }


}