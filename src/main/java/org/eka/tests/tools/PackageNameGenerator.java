package org.eka.tests.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PackageNameGenerator {
    public String generate(int num) {
        return new Solution(".", String::toLowerCase).numberToWords(num);
    }

    static class Solution {
        static final int THOUSAND = 1000;
        final String separator;
        final Function<String, String> function;

        public Solution() {
            this.separator = " ";
            this.function = (String s) -> s;
        }

        public Solution(String separator, Function<String, String> function) {
            this.separator = separator;
            this.function = function;
        }

        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(num % THOUSAND);
            num = num / THOUSAND;
            while (num > 0) {
                stack.push(num % THOUSAND);
                num = num / THOUSAND;
            }
            int size = stack.size();
            List<String> parts = new ArrayList<>();
            for (int i = size - 1; i >= 0; i--) {
                parts.addAll(getNumberWithRegisterParts(stack.pop(), i));
            }
            return parts.stream().filter(item -> item != null && !item.isEmpty()).map(function).collect(Collectors.joining(separator));
        }

        List<String> getNumberWithRegisterParts(int value, int register) {
            List<String> result = new ArrayList<>();
            result.addAll(getNumberParts(value));
            if (register > 0 && !result.isEmpty()) {
                result.add(getRegisterValue(register));
            }
            return result;
        }

        List<String> getNumberParts(int value) {
            List<String> result = new ArrayList<>();
            int hundred = value / 100;
            if (hundred > 0) {
                result.add(getNumberValue(hundred));
                result.add("Hundred");
                value = value % 100;
            }
            int tens = value / 10;
            if (tens > 1) {
                result.add(getNumberValue(tens * 10));
                value = value % 10;
            }
            if (value > 0) {
                result.add(getNumberValue(value));
            }
            return result;
        }

        String getNumberValue(int value) {
            switch (value) {
                case 0:
                    return "Null";
                case 1:
                    return "One";
                case 2:
                    return "Two";
                case 3:
                    return "Three";
                case 4:
                    return "Four";
                case 5:
                    return "Five";
                case 6:
                    return "Six";
                case 7:
                    return "Seven";
                case 8:
                    return "Eight";
                case 9:
                    return "Nine";
                case 10:
                    return "Ten";
                case 11:
                    return "Eleven";
                case 12:
                    return "Twelve";
                case 13:
                    return "Thirteen";
                case 14:
                    return "Fourteen";
                case 15:
                    return "Fifteen";
                case 16:
                    return "Sixteen";
                case 17:
                    return "Seventeen";
                case 18:
                    return "Eighteen";
                case 19:
                    return "Nineteen";
                case 20:
                    return "Twenty";
                case 30:
                    return "Thirty";
                case 40:
                    return "Forty";
                case 50:
                    return "Fifty";
                case 60:
                    return "Sixty";
                case 70:
                    return "Seventy";
                case 80:
                    return "Eighty";
                case 90:
                    return "Ninety";
                default:
                    assert false;
            }
            return "";
        }

        String getRegisterValue(int register) {
            switch (register) {
                case 1:
                    return "Thousand";
                case 2:
                    return "Million";
                case 3:
                    return "Billion";
                default:
                    assert false;
            }
            return "";
        }
    }
}
