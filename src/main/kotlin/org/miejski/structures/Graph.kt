package org.miejski.structures

import java.util.*


data class Graph(val nodes: List<Node>)

data class Node(val value: Int, val nodes: MutableList<Node>) {

    constructor(id: Int, value: Int, nodes: MutableList<Node>) : this(value, nodes) {
        this.id = id
    }

    var id: Int = -1

    companion object {
        var nodes: Int = 0
        fun next(): Int {
            return nodes++
        }
    }

    init {
        id = next()
    }

    fun addNode(node: Node) {
        nodes.add(node)
    }
}


class GraphBuilder {

    data class NodeN(val id: Int, val value: Int, val nodes: List<Int>)

    fun build(nodes: List<NodeN>): Graph {

        val nodesById = nodes.map { Pair(it.id, Node(it.id, it.value, mutableListOf())) }.toMap()

        nodes.forEach { n ->
            n.nodes.forEach { nn ->
                nodesById[n.id]!!.addNode(nodesById[nn]!!)
            }
        }
        val startingNode = nodesById.minBy { it.key }!!.value
        return Graph(listOf(startingNode))
    }

}