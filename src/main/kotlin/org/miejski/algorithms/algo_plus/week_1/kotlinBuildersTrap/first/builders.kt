package org.miejski.algorithms.algo_plus.week_1.kotlinBuildersTrap.first

import org.miejski.algorithms.algo_plus.week_1.Color
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

    fun mixed(init: SomeNode.() -> Unit) {
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
        black()
        black()
        mixed {
            white()
            white()
        }
    }

    if(mixedNode.children.size != 3 || mixedNode.children.get(2).children.size != 2) {
        throw RuntimeException()
    }
    println("Seems fine, but mixedNode has 5 children!!!")
}
