package org.eka.tests.common;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedListNode<T> {
    public T val;
    public DoublyLinkedListNode<T> prev;
    public DoublyLinkedListNode<T> next;

    public DoublyLinkedListNode(T x) {
        val = x;
    }

    public DoublyLinkedListNode<T> insertPrev(DoublyLinkedListNode<T> newPrev) {
        if(newPrev != null) {
            if (newPrev.next != null) {
                newPrev.next.prev = newPrev.prev;
            }
            if (newPrev.prev != null) {
                newPrev.prev.next = newPrev.prev;
            }
        }
        if (prev != null) {
            prev.next = newPrev;
        }
        if(newPrev != null) {
            newPrev.prev = prev;
            newPrev.next = this;
        }
        prev = newPrev;
        return newPrev;
    }

    public DoublyLinkedListNode<T> insertNext(DoublyLinkedListNode<T> newNext) {
        if(newNext != null) {
            if (newNext.next != null) {
                newNext.next.prev = newNext.prev;
            }
            if (newNext.prev != null) {
                newNext.prev.next = newNext.prev;
            }
        }
        if (next != null) {
            next.prev = newNext;
        }
        if(newNext != null) {
            newNext.next = next;
            newNext.prev = this;
        }
        next = newNext;
        return newNext;
    }

    public List<T> toList() {
        DoublyLinkedListNode<T> node = getTopParent();
        List<T> result = new ArrayList<>();
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        return result;
    }

    public DoublyLinkedListNode<T> getTopParent() {
        if(prev == null) {
            return this;
        }
        return prev.getTopParent();
    }
}
