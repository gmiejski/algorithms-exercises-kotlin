package org.miejski.algorithms.algo_plus.week_1.quadtree.nodes

import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.Color
import org.miejski.algorithms.algo_plus.week_1.quadtree.MaxSizeArrayList
import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.QuadNode
import java.util.*

class BlackNode : QuadNode {
    override val children: MaxSizeArrayList<QuadNode> by lazy { MaxSizeArrayList<QuadNode>((1..4).map { BlackNode() }.toMutableList(), 4) }
    override val color: Color = Color.BLACK
    override val id = UUID.randomUUID().toString()
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as BlackNode

        if (color != other.color) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int{
        var result = color.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }
}