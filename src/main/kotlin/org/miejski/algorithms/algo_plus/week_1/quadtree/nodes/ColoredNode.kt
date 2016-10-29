package org.miejski.algorithms.algo_plus.week_1.quadtree.nodes

import org.miejski.algorithms.algo_plus.week_1.quadtree.MaxSizeArrayList

class ColoredNode(override val color: Color) : QuadNode {
    override val children: MaxSizeArrayList<QuadNode> by lazy { MaxSizeArrayList<QuadNode>((1..4).map { ColoredNode(color) }.toMutableList(), 4) }
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as ColoredNode

        if (color != other.color) return false

        return true
    }

    override fun hashCode(): Int{
        return color.hashCode()
    }

}