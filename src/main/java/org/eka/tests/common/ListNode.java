package org.eka.tests.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(String string) {
        String tail = parseValue(string);
        if (tail != null && !tail.isEmpty()) {
            next = new ListNode(tail);
        }
    }

    @Override
    public String toString() {
        return val + (next != null ? "->" + next.toString() : "");
    }

    public static String toString(ListNode node) {
        return node != null ? node.toString() : "";
    }

    private String parseValue(String string) {
        int pos = 0;
        for (; pos <= string.length(); pos++) {
            if(pos == string.length() || string.charAt(pos) < '0' || string.charAt(pos) > '9') {
                break;
            }
        }
        try {
            val = Integer.parseInt(string.substring(0, pos));
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if(string.length() > pos) {
            if(string.length() < pos + 2 || string.charAt(pos) != '-' || string.charAt(pos + 1) != '>') {
                throw new IllegalArgumentException();
            }
            return string.substring(pos + 2);
        }
        return null;
    }
}
