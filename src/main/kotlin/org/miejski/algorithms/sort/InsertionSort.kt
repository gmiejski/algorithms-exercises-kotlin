package org.miejski.algorithms.sort

class InsertionSort :Sort{
    override fun sort(data: Array<Int>): Array<Int> {
        for ( i in (1..data.size-1)) {
            for (j in (1..i).reversed()) {
                if ( data[j-1] > data[j]) {
                    val temp = data[j-1]
                    data[j-1] = data[j]
                    data[j] = temp
                }
            }
        }
        return data
    }
}