package org.eka.tests.common.solution;

import java.util.function.Supplier;

public abstract class ISolution {
    public abstract void allTests();

    public void test(String src, Supplier<String> result, String expected) {
        System.out.println(String.format("---- TEST (%s): started (%s), expected: %s", this.getClass().getName(), src, expected));
        String actual = result.get();
        if(actual.equals(expected)) {
            System.out.println(String.format("---- TEST (%s): SUCCESS (%s), expected: %s, result: %s", this.getClass().getName(), src, expected, actual));
        } else {
            System.out.println(String.format("---- TEST (%s): FAILED (%s), expected: %s, result: %s", this.getClass().getName(), src, expected, actual));
        }
    }
}
