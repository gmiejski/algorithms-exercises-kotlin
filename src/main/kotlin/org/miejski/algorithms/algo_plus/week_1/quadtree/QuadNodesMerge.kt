package org.miejski.algorithms.algo_plus.week_1.quadtree

import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.Color
import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.ColoredNode
import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.MixedNode
import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.QuadNode


class QuadNodesMerge {

    fun merge(a: QuadNode, b: QuadNode): QuadNode {

        fun mergeNodes(a: QuadNode, b: QuadNode): QuadNode {
            if (a.color.equals(Color.BLACK) || b.color.equals(Color.BLACK)) {
                return ColoredNode(Color.BLACK)
            }

            if (a.color.equals(Color.WHITE) && b.color.equals(Color.WHITE)) {
                return ColoredNode(Color.WHITE)
            }

            val children = a.children.zip(b.children).map { mergeNodes(it.first, it.second) }
            if (children.map { it.color }.distinct().size == 1) {
                return ColoredNode(children.first().color)
            }
            return MixedNode(children)
        }

        return mergeNodes(a, b)
    }
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

    val expectedResult = QuadNodeBuilder.mixed {
        black()
        black()
        black()
        mixed {
            white()
            white()
            black()
            black()
        }
    }

    if (!QuadNodesMerge().merge(node, node2).equals(expectedResult)) {
        throw AssertionError()
    }
}