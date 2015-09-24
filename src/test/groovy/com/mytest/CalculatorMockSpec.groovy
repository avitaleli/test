package com.mytest

import spock.lang.Specification

/**
 * Created by eli on 24/09/15.
 */
class CalculatorMockSpec extends Specification {

    private Calculator calculator = Mock(Calculator)

    def setup() {
        calculator.add(_) >> 10
    }

    def "test arbitrary add"() {
        when:
            def result = calculator.add([1, 2, 3])
        then:
            result == 10
    }
}
