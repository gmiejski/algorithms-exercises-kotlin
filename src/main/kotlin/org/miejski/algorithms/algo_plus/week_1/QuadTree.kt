package org.miejski.algorithms.algo_plus.week_1

/**
 * https://en.wikipedia.org/wiki/Quadtree
 * Implement the structure and merge of 2 such trees
 */

enum class Color {
    BLACK, WHITE, MIXED
}

class MaxSizeArrayList<T>(val list: MutableList<T>, val capacity: Int) : MutableList<T> by list {

    override fun add(element: T): Boolean {
        if (list.size == capacity) {
            throw RuntimeException("MaxSizeArray size exceeded: current size = ${list.size}")
        }
        list.add(element)
        return true
    }

    override fun add(index: Int, element: T) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun addAll(elements: Collection<T>): Boolean {
        throw UnsupportedOperationException("not implemented")
    }
}

interface QuadNode {
    val color: Color
    val children: MaxSizeArrayList<QuadNode>
}

class BlackNode : QuadNode {
    override val children: MaxSizeArrayList<QuadNode> by lazy { MaxSizeArrayList<QuadNode>((1..4).map { BlackNode() }.toMutableList(), 4) }
    override val color: Color = Color.BLACK
}

class WhiteNode : QuadNode {
    override val children: MaxSizeArrayList<QuadNode> by lazy { MaxSizeArrayList<QuadNode>((1..4).map { WhiteNode() }.toMutableList(), 4) }
    override val color: Color = Color.WHITE
}

class MixedNode() : QuadNode {
    override val children: MaxSizeArrayList<QuadNode> = MaxSizeArrayList(mutableListOf(), 4)
    override val color: Color = Color.MIXED

    fun black(): BlackNode {
        val blackNode = BlackNode()
        children.add(blackNode)
        return blackNode
    }

    fun white(): WhiteNode {
        val whiteNode = WhiteNode()
        children.add(whiteNode)
        return whiteNode
    }

    fun mixed(init: MixedNode.() -> Unit): MixedNode {
        val mixedNode = MixedNode()
        mixedNode.init()
        children.add(mixedNode)
        return mixedNode
    }
}

class NewNodeBuilder {
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

fun main(args: Array<String>) {

    val node = NewNodeBuilder.mixed {
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

    println("ad")
}
