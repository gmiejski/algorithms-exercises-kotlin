package org.miejski.algorithms.algo_plus.week_1.kotlinBuildersTrap.second

import org.miejski.algorithms.algo_plus.week_1.quadtree.nodes.Color
import java.util.*


interface SomeNode {
    val color: Color
    val children: ArrayList<SomeNode>
}

class NodeA : SomeNode {
    override val children: ArrayList<SomeNode> by lazy { ArrayList<SomeNode>((1..4).map { NodeA() }.toList()) }
    override val color: Color = Color.BLACK
}

class NodeB : SomeNode {
    override val children: ArrayList<SomeNode> by lazy { ArrayList<SomeNode>((1..4).map { NodeB() }.toList()) }
    override val color: Color = Color.WHITE
}

class NodeMix() : SomeNode {
    override val children: ArrayList<SomeNode> = ArrayList()
    override val color: Color = Color.MIXED

    fun black() {
        val blackNode = NodeA()
        children.add(blackNode)
    }

    fun white() {
        val whiteNode = NodeB()
        children.add(whiteNode)
    }

    fun mixed(init: SomeNode.() -> Unit) { // PROBLEM lies here
        val mixedNode = NodeMix()
        mixedNode.init()
        children.add(mixedNode)
    }
}

class NewNodeBuilder {
    fun mixed(init: NodeMix.() -> Unit): NodeMix {
        val mixedNode = NodeMix()
        mixedNode.init()
        return mixedNode
    }
}

fun main(args: Array<String>) {

    val mixedNode = NewNodeBuilder().mixed {
        this.black()
        this.black()
        this.mixed {
//            this.white() -> no method white() in this!
//            this.white() -> no method white() in this!
        }
    }
    println("Seems fine, but mixedNode has 5 children!!!")
}
