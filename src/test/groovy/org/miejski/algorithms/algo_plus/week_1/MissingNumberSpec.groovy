package org.miejski.algorithms.algo_plus.week_1

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


class MissingNumberSpec extends Specification {


    @Shared
    static def MissingNumber missingNumber = new MissingNumber()

    @Unroll
    def "should find missing number"() {
        given:

        expect:
        missingNumber.findMissing(input) == expectedNumber

        where:
        input                              | expectedNumber
        [0, 1, 3, 4, 5]                             | 2
        [0, 2, 3, 4, 5, 6, 7]                       | 1
        missingNumber.prepareList(100, 2) | 2
        missingNumber.prepareList(100, 99) | 99
        missingNumber.prepareList(100, 0)  | 0
        missingNumber.prepareList(100, 50) | 50
    }
}
