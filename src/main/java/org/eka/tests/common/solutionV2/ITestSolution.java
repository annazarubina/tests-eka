package org.eka.tests.common.solutionV2;

import org.eka.tests.tools.JsonParser;

import java.util.function.Supplier;

public abstract class ITestSolution<I, O> {
    private String name = "";

    protected void setName(String name) {
        this.name = name;
    }

    protected O process(I input) { return null; }

    protected abstract void allTests();

    public void execute() {
        System.out.println("\n" + name + "\n");
        allTests();
    }

    protected void test(String src, Supplier<String> result, String expected) {
        System.out.println(String.format("---- TEST (%s): STARTED (%s), \n     expected: %s", this.getClass().getName(), src, expected));
        String actual = result.get();
        if (actual.equals(expected)) {
            System.out.println(String.format("\u001B[32m     TEST (%s): SUCCESS (%s),\n     result:   %s\u001B[0m", this.getClass().getName(), src, actual));
        } else {
            System.out.println(String.format("\u001B[31m     TEST (%s): FAILED (%s),\n     result:   %s\u001B[0m", this.getClass().getName(), src, actual));
        }
    }

    protected void testFromFile(String filePath, Class<I> iClass, Class<O> oClass) {
        TestData<I, O> data = new JsonParser().loadFromResources(filePath, iClass, oClass);
        test(data.input.toString(), () -> process(data.input).toString(), data.expected.toString());
    }

    protected void testFromJson(String jsonString, Class<I> iClass, Class<O> oClass) {
        TestData<I, O> data = new JsonParser().loadFromJsonString(jsonString, iClass, oClass);
        test(data.input.toString(), () -> process(data.input).toString(), data.expected.toString());
    }
}
