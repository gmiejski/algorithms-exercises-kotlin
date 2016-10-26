package org.miejski.algorithms.algo_plus.week_1

import spock.lang.Specification
import spock.lang.Unroll

class LongestCommonSubstringWithMaxUniqueCharsSpec extends Specification {


    @Unroll
    def "should properly find longest common substring with proper unique chars count"() {
        expect:
        new LongestCommonSubstringWithMaxUniqueChars().find(input, uniqueCount) == expectedSize

        where:
        input                 | uniqueCount | expectedSize
        'axyxzyxyb'           | 3           | 7
        'abcabefkskbsbgdnwi'  | 3           | 6
        'aaaaaaaaaaaaaaaabcc' | 2           | 17
        'aaaaaaaaaaaaaaaabcc' | 1           | 16
        'abcdefgha'           | 7           | 7
    }
}
