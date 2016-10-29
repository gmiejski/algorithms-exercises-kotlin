package org.miejski.algorithms.algo_plus.week_1.quadtree

import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.*


data class QuadNodeHead(val head: QuadNode)

fun merge(a: QuadNode, b: QuadNode): QuadNode {

    fun mergeNodes(a: QuadNode, b: QuadNode): QuadNode {
        if (a.color.equals(Color.BLACK) || b.color.equals(Color.BLACK)) {
            return BlackNode()
        }

        if (a.color.equals(Color.WHITE) && b.color.equals(Color.WHITE)) {
            return WhiteNode()
        }

        val children = a.children.zip(b.children).map { mergeNodes(it.first, it.second) }
        if (children.map { it.color }.distinct().size==1) {
            when(children.first().color) {
                Color.BLACK -> return BlackNode()
                Color.WHITE -> return WhiteNode()
            }
        }
        return MixedNode(children)
    }

    return mergeNodes(a, b)
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

    val node3 = QuadNodeBuilder.mixed {
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

    val node2 = QuadNodeBuilder.mixed {
        mixed {
            white()
            white()
            white()
            black()
        }
        white()
        mixed {
            black()
            black()
            white()
            white()
        }
        mixed {
            white()
            black()
            white()
            black()
        }
    }


    val merged = merge(node, node2)
    println("Finished merging")
}
