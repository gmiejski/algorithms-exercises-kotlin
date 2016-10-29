package org.miejski.algorithms.algo_plus.week_1.quadtree.nodes

import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.Color
import org.miejski.algorithms.algo_plus.week_1.quadtree.MaxSizeArrayList

interface QuadNode {
    val color: Color
    val children: MaxSizeArrayList<QuadNode>
    val id: String
}