package org.miejski.algorithms.notation

import spock.lang.Specification
import spock.lang.Unroll


class PolishNotationSpec extends Specification {

    @Unroll
    def "should properly cast to reverse polish notation"() {
        expect:
        rpn == new PolishReverseNotation().toReversePolishNotation(sentence)

        where:
        sentence      | rpn
        "2+(3*5)"     | "235*+".split("").toList()
        "(a+b)*(z+x)" | "ab+zx+*".split("").toList()
        "(a+t)*((b+(a+c))^(c+d))" | "at+bac++cd+^*".split("").toList()
        "3+((4*2)/((1-5)^2))" | "342*15-2^/+".split("").toList()
    }

    def "should properly return sentence end index"() {
        expect:
        new PolishReverseNotation().sentenceEndIndex(sentence, 0) == expectedIndex

        where:
        sentence                | expectedIndex
        "((a+b)*c+2)+(3*(3+2))" | 10
        "(((a+b)*c+2)+(3+2))"   | 18
    }

    def "should properly return operator end index"() {
        expect:
        new PolishReverseNotation().operatorEndIndex(sentence, 0) == expectedIndex

        where:
        sentence     | expectedIndex
        "1234+32142" | 4
        "23421"      | 5
        "1"          | 1
    }
}
