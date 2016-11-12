package org.miejski.algorithms.algo_plus.week_2

import org.miejski.structures.Graph
import org.miejski.structures.Node
import java.util.*

/**
 * We have tasks in system. Each task has time it takes to complete and other tasks that has to be completed before start working on this one.
 * Given a graph of tasks predict minimum time to complete all tasks.
 */
class MinTimeForTasks {

    fun computeMinTime(graph: Graph): Int {

        val startingNode = graph.nodes.first()
        val inDegreeMap = createInDegreeMap(startingNode)
        val timeToStartTask = createMinTimeToStartTaskMap(startingNode)

        val q = LinkedList<Node>()

        q.add(startingNode)
//        timeToStartTask[startingNode.id] = startingNode.value

        while (q.isNotEmpty()) {
            val currNode = q.pop()

            val currNodeFinishTime = currNode.value + timeToStartTask[currNode.id]!!

            currNode.nodes.forEach {
                inDegreeMap.put(it.id, inDegreeMap[it.id]!! - 1)
                if (inDegreeMap[it.id] == 0) {
                    q.add(it)
                }

                val currMinTimeToStart = timeToStartTask[it.id]!!
                if (currNodeFinishTime > currMinTimeToStart) {
                    timeToStartTask[it.id] = currNodeFinishTime
                }
            }
        }

        val result = timeToStartTask.maxBy { it.value }!!.value
        println(result)
        return result
    }

    private fun createMinTimeToStartTaskMap(startingNode: Node): HashMap<Int, Int> {
        return defaultValForEachNode(startingNode, 0)
    }

    private fun <T> defaultValForEachNode(startingNode: Node, value: T): HashMap<Int, T> {
        val m = HashMap<Int, T>()

        val q = LinkedList<Node>()
        q.add(startingNode)
        while (q.isNotEmpty()) {
            val node = q.pop()
            if (!m.containsKey(node.id)) {
                m.put(node.id, value)
            }
            node.nodes.forEach {
                q.add(it)
            }
        }
        return m
    }

    private fun createInDegreeMap(startingNode: Node): HashMap<Int, Int> {
        val m = defaultValForEachNode(startingNode, 0)
        val visitedMap = defaultValForEachNode(startingNode, false)

        val q = LinkedList<Node>()
        q.add(startingNode)

        while (q.isNotEmpty()) {
            val node = q.pop()
            node.nodes.forEach {
                m[it.id] = m[it.id]!! + 1
                if (!visitedMap[it.id]!!) {
                    q.add(it)
                    visitedMap[it.id] = true
                }
            }
        }
        return m
    }

}