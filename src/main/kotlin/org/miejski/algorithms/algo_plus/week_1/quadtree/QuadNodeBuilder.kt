package org.miejski.algorithms.algo_plus.week_1.quadtree

import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.*

class QuadNodeBuilder {
    companion object {
        fun black(): BlackNode {
            val blackNode = BlackNode()
            return BlackNode()
        }

        fun white(): WhiteNode {
            val whiteNode = WhiteNode()
            return whiteNode
        }

        fun mixed(init: MixedNode.() -> Unit): MixedNode {
            val mixedNode = MixedNode()
            mixedNode.init()
            verify(mixedNode)
            return mixedNode
        }

        fun verify(node: QuadNode) {
            if (node.color.equals(Color.MIXED)) {
                if (node.children.size != 4) {
                    throw RuntimeException("Mixed node must have 4 children, bus has ${node.children.size}")
                }
                node.children.forEach { verify(it) }
            }
        }
    }
}