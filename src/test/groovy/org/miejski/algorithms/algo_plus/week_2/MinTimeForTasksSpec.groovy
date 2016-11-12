package org.miejski.algorithms.algo_plus.week_2

import org.miejski.structures.GraphBuilder
import spock.lang.Specification

class MinTimeForTasksSpec extends Specification {


    def "should do it properly!"() {
        given:
        def n1 = new GraphBuilder.NodeN(1, 10, [2, 3, 4])
        def n2 = new GraphBuilder.NodeN(2, 13, [5])
        def n3 = new GraphBuilder.NodeN(3, 5, [6])
        def n4 = new GraphBuilder.NodeN(4, 3, [3])
        def n5 = new GraphBuilder.NodeN(5, 10, [6])
        def n6 = new GraphBuilder.NodeN(6, 15, [])
        def graph = new GraphBuilder().build([n1, n2, n3, n4, n5, n6])

        expect:
        new MinTimeForTasks().computeMinTime(graph) == 33

    }
}
