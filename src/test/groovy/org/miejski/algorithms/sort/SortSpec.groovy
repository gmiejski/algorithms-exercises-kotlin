package org.miejski.algorithms.sort

import spock.lang.Specification
import spock.lang.Unroll


class SortSpec extends Specification {
    def static ARRAY_SIZE = 1000

    def random = new Random()

    @Unroll
    def "should properly sort random data"() {
        given:
        def data = (1..ARRAY_SIZE).collect { random.nextInt() }

        expect:
        sortingAlgorithm.sort(data.toArray(new Integer[data.size()])).toList() == data.sort()

        where:
        sortingAlgorithm    | _
        new SelectionSort() | _
        new BubbleSort()    | _
        new InsertionSort() | _
        new MergeSort()     | _
        new QuickSort()     | _
        new HeapSort()      | _
        new BucketSort()    | _
    }

    @Unroll
    def "should properly return already sorted data"() {
        def data = (1..ARRAY_SIZE).collect { random.nextInt() }
        def sortedData = data.sort()

        expect:
        sortingAlgorithm.sort(data.toArray(new Integer[data.size()])).toList() == sortedData

        where:
        sortingAlgorithm    | _
        new SelectionSort() | _
        new BubbleSort()    | _
        new InsertionSort() | _
        new MergeSort()     | _
        new QuickSort()     | _
        new HeapSort()      | _
        new BucketSort()    | _
    }

    @Unroll
    def "should properly sort reversely sorted data:"() {
        def data = (1..ARRAY_SIZE).collect { random.nextInt() }
        def sortedData = data.sort().reverse()

        expect:
        sortingAlgorithm.sort(sortedData.toArray(new Integer[data.size()])).toList() == data.sort()

        where:
        sortingAlgorithm    | _
        new SelectionSort() | _
        new BubbleSort()    | _
        new InsertionSort() | _
        new MergeSort()     | _
        new QuickSort()     | _
        new HeapSort()      | _
        new BucketSort()    | _
    }

    def "testing test"() {
        def data = [-38, -27, 43, 3, 9, 82, 10]
//        def data = [78,17,39,26,72,94,21,12,23,62]
        def sortingAlgorithm = new BucketSort()
        expect:
        sortingAlgorithm.sort(data.toArray(new Integer[data.size()])).toList() == data.sort()
    }
}
