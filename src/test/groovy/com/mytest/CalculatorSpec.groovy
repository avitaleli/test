package com.mytest

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 * Created by eli on 24/09/15.
 */
class CalculatorSpec extends Specification {

    @Subject
    private Calculator calculator

    def setup() {
        calculator = new Calculator()
    }

    def "test add calc"() {
        when:
            def result = calculator.add([1, 2, 3, 4, 5])
        then:
            result == 15
    }

    @Unroll("numbers: #a result: #b")
//    @Unroll
    def "test multiply calc"() {
        expect:
            calculator.multiply(a) == b

        where:
            a << [[1, 2, 3, 4, 5], [4, 5], [1, 1, 1]]
            b << [120, 20, 3]
    }
}
