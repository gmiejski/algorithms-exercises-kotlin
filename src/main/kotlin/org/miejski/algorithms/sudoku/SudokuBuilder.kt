package org.miejski.algorithms.sudoku

import java.io.InputStream
import java.util.*

class SudokuBuilder {

    fun fromInput(input: InputStream): Sudoku {

        val scanner = Scanner(input)
        val fullTable: ArrayList<ArrayList<Int>> = ArrayList(9)
        for (i in (0..9)) {
            val elements = ArrayList(scanner.nextLine().split("").map { toNumber(it) })
            assert(elements.size == 9)
            fullTable.add(elements)
        }
        return Sudoku(fullTable)
    }


    private fun toNumber(number: String): Int {
        try {
            return number.toInt()
        } catch (x: NumberFormatException) {
            return 0
        }
    }

}