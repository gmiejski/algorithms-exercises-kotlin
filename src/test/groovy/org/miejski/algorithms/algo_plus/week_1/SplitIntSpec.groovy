package org.miejski.algorithms.algo_plus.week_1

import spock.lang.Specification
import spock.lang.Unroll


class SplitIntSpec extends Specification {

    @Unroll
    def "should properly split the number"() {
        expect:
        new SplitInt().split(number) == result

        where:
        number   | result
        100_000  | "100'000"
        5        | "5"
        100_001  | "100'001"
        0        | "0"
        -100_001 | "-100'001"
    }
}
