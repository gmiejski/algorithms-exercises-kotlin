package org.miejski.algorithms.algo_plus.week_1.quadtree

import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.*


data class QuadNodeHead(val head: QuadNode)

fun merge(a: QuadNodeHead, b: QuadNodeHead): QuadNode {

    fun mergeNodes(a: QuadNode, b: QuadNode): QuadNode {
        if(a.color.equals(Color.BLACK) || b.color.equals(Color.BLACK)) {
            return BlackNode()
        }
        

        if (a.color.equals(b.color)) {
            when(a.color) {
                Color.BLACK -> return BlackNode()
                Color.WHITE -> return WhiteNode()
            }
        }

        return MixedNode(a.children.zip(b.children).map { mergeNodes(it.first, it.second) })
    }

    return mergeNodes(a.head, b.head)
}


fun main(args: Array<String>) {

    val node = QuadNodeBuilder.mixed {
        black()
        black()
        mixed {
            white()
            white()
            black()
            black()
        }
        white()
    }

    println("Finished merging")
}
