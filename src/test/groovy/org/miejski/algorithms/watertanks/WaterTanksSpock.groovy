package org.miejski.algorithms.watertanks

import spock.lang.Specification
import spock.lang.Unroll

class WaterTanksSpock extends Specification {


    @Unroll
    def "should return proper value for given input data"() {
        expect:
        new WaterTanks().calculateWaterCapacity(input.toArray((new Integer[input.size()]))) == expectedResult

        where:
        input                               | expectedResult
        [1, 2, 1]                           | 0
        [2, 6, 3, 5, 2, 8, 1, 4, 2, 3]      | 12
        [1, 1, 1, 3, 2, 5, 2, 2, 1, 1]      | 1
        [11, 1, 1, 1, 1, 9, 1, 1, 1, 1, 11] | 82
    }
}4
