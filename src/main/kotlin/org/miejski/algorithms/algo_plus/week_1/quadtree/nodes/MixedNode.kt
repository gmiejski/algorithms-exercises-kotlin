package org.miejski.algorithms.algo_plus.week_1.quadtree.nodes

import org.miejski.algorithms.algo_plus.week_1.quadtree.MaxSizeArrayList
import java.util.*

class MixedNode() : QuadNode {
    override val children: MaxSizeArrayList<QuadNode> = MaxSizeArrayList(mutableListOf(), 4)
    override val color: Color = Color.MIXED
    override val id = UUID.randomUUID().toString()

    constructor(elements: List<QuadNode>) : this() {
        elements.forEach { children.add(it) }
    }

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