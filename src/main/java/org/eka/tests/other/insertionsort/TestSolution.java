package org.eka.tests.other.insertionsort;

import org.eka.tests.common.solutionV2.ITestSolution;

public class TestSolution extends ITestSolution<Input, Output> {
    public TestSolution() {
        setName("Insertion sort");
    }

    protected Output process(Input input) {
        return new Output(new Solution().sort(input.nums));
    }

    @Override
    protected void allTests() {
        testFromJson("{\n" +
                        "\"input\": {\"nums\": [7, 2, 5, 10, 8]},\n" +
                        "\"expected\": {\"res\": [2, 5, 7, 8, 10]}\n" +
                        "}",
                Input.class, Output.class);
        testFromFile("test1.json", Input.class, Output.class);
     }
}
