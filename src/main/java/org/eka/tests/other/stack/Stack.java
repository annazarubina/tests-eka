package org.eka.tests.other.stack;

public class Stack {
    int capacity = 100;
    int[] arr = new int[capacity];
    int size = 0;

    int push(int value) {
        if(size >= capacity) {
            System.out.println("Stack overflow");
            return -1;
        }
        arr[size] = value;
        size++;
        return size - 1;
    }

    int pop() {
        if(size <= 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        int result = arr[size - 1];
        size--;
        return result;
    }
}
