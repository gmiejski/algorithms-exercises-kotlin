package org.miejski.algorithms.algo_plus.week_1.quadtree.nodes

import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.Color
import org.miejski.algorithms.algo_plus.week_1.quadtree.MaxSizeArrayList
import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.QuadNode
import java.util.*

class WhiteNode : QuadNode {
    override val children: MaxSizeArrayList<QuadNode> by lazy { MaxSizeArrayList<QuadNode>((1..4).map { WhiteNode() }.toMutableList(), 4) }
    override val color: Color = Color.WHITE
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        return true
    }

    override fun hashCode(): Int{
        return color.hashCode()
    }
}