package org.eka.tests.other.quicksort;

import org.eka.tests.common.solutionV2.ITestSolution;

public class TestSolution extends ITestSolution<Input, Output> {
    public TestSolution() {
        setName("Merge sort");
    }

    protected Output process(Input input) {
        return new Output(new Solution().sort(input.nums));
    }

    @Override
    protected void allTests() {
        testFromJson("{\n" +
                        "\"input\": {\"nums\": [7, 9, 5, 10, 8]},\n" +
                        "\"expected\": {\"res\": [5, 7, 8, 9, 10]}\n" +
                        "}",
                Input.class, Output.class);
        testFromFile("test1.json", Input.class, Output.class);
     }
}
