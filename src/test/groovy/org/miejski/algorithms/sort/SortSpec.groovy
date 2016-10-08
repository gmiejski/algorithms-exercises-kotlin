package org.miejski.algorithms.sort

import spock.lang.Specification


class SortSpec extends Specification {
    def static ARRAY_SIZE = 1000

    def random = new Random()

    def "should properly sort random data"() {
        given:
        def data = (1..ARRAY_SIZE).collect { random.nextInt() }

        expect:
        sortingAlgorithm.sort(data.toArray(new Integer[data.size()])).toList() == data.sort()

        where:
        sortingAlgorithm    | _
        new SelectionSort() | _
    }

    def "should properly return already sorted data"() {
        def data = (1..ARRAY_SIZE).collect { random.nextInt() }
        def sortedData = data.sort()

        expect:
        sortingAlgorithm.sort(data.toArray(new Integer[data.size()])).toList() == sortedData

        where:
        sortingAlgorithm    | _
        new SelectionSort() | _
    }

    def "should properly sort reversely sorted data"() {
        def data = (1..ARRAY_SIZE).collect { random.nextInt() }
        def sortedData = data.sort().reverse()

        expect:
        sortingAlgorithm.sort(sortedData.toArray(new Integer[data.size()])).toList() == data.sort()

        where:
        sortingAlgorithm    | _
        new SelectionSort() | _
    }
}
