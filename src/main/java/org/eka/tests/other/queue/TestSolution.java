package org.eka.tests.other.queue;

import org.eka.tests.common.solutionV2.ITestSolution;

public class TestSolution extends ITestSolution<String, String> {
    public TestSolution() {
        setName("Queue");
    }

    @Override
    protected void allTests() {
        Queue queue = new Queue();
        queue.push(10);
        queue.push(11);
        queue.push(12);
        int val1 = queue.pop();
        queue.push(13);
        int val2 = queue.pop();

     }
}
