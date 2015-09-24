package com.mytest;

import java.util.List;

/**
 * Created by eli on 24/09/15.
 */
public class Calculator {

    public Calculator() {
        super();
    }

    public int add(List<Integer> ints) {
        int sum = 0;
        for (Integer integer : ints) {
            sum += integer;
        }
        return sum;
    }

    public int multiply(List<Integer> ints) {
        int mult = 1;
        for (Integer integer : ints) {
            mult *= integer;
        }
        return mult;
    }
}
