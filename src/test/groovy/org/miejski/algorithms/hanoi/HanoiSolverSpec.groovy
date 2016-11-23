package org.miejski.algorithms.hanoi

import spock.lang.Specification

class HanoiSolverSpec extends Specification {


    def "should move hanoi correctly"() {
        when:
        def stacks = HanoiSolver.solve(10)

        then:
        stacks.forEach({ print(it.toString()) })
    }
}
