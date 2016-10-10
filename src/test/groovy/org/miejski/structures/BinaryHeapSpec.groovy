package org.miejski.structures

import spock.lang.Specification

class BinaryHeapSpec extends Specification {

    def "should create a max heap using adding elements to empty heap"() {
        given:
        def data = [8, 4, 3, 5, 11]

        when:
        def bh = BinaryHeap.create(data.toArray(new Integer[data.size()]))

        then:
        bh.data == [11, 8, 3, 4, 5].toArray(new Integer[data.size()])
    }

    def "should create a max heap using heapify"() {
        given:
        def data = [8, 4, 3, 5, 11]

        when:
        def bh = BinaryHeap.createWithHeapify(data.toArray(new Integer[data.size()]))

        then:
        bh.data == [11, 8, 3, 5, 4].toArray(new Integer[data.size()])
    }
}
