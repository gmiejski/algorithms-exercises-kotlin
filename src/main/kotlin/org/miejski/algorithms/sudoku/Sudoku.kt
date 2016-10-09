package org.miejski.algorithms.sudoku

import java.util.*

class Sudoku(val table : ArrayList<ArrayList<Int>>) {

    fun print() {
        for (x in (0..table.size)) {
            println(x)
        }
    }
}

fun main(args: Array<String>) {
    val sudoku = SudokuBuilder().fromInput(System.`in`)
    sudoku.print()
}