package org.miejski.algorithms.search

import spock.lang.Specification
import spock.lang.Unroll


class BinarySearchSpec extends Specification {

    def random = new Random()

    @Unroll
    def "should find proper index of given value"() {
        expect:
        new BinarySearch().find(data.toArray(new Integer[data.size()]), valueToFind) == expectedIndex

        where:
        data                 | valueToFind | expectedIndex
        [1, 2, 3, 4]         | 2           | 1
        [1]                  | 1           | 0
        [1]                  | 10          | -1
        [1, 3, 5, 8, 10, 30] | 10          | 4
        [1, 3, 5, 8, 10, 30] | 15          | -1

    }

    def "should work properly for big numbers"() {
        given:
        def data = (1..1000).collect { random.nextInt() }.sort()
        def expected_index = random.nextInt(data.size())

        expect:
        new BinarySearch().find(data.toArray(new Integer[data.size()]), data[expected_index]) == expected_index
    }
}
