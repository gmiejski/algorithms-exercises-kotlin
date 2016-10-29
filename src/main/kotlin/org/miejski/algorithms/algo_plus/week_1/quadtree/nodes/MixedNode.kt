package org.miejski.algorithms.algo_plus.week_1.quadtree.nodes

import org.miejski.algorithms.algo_plus.week_1.quadtree.MaxSizeArrayList
import java.util.*

class MixedNode() : QuadNode {
    override val children: MaxSizeArrayList<QuadNode> = MaxSizeArrayList(mutableListOf(), 4)
    override val color: Color = Color.MIXED

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as MixedNode
        return Objects.equals(color, other.color) && children.zip(other.children).map { it.first.equals(it.second) }
            .foldRight(true, { t, r -> t })
    }

    override fun hashCode(): Int {
        var result = children.hashCode()
        result = 31 * result + color.hashCode()
        return result
    }
}