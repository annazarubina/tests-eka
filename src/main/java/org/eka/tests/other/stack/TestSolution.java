package org.eka.tests.other.stack;

import org.eka.tests.common.solutionV2.ITestSolution;

public class TestSolution extends ITestSolution<String, String> {
    public TestSolution() {
        setName("Stack");
    }

    @Override
    protected void allTests() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(11);
        int val1 = stack.pop();
        stack.push(12);
        int val2 = stack.pop();
     }
}
