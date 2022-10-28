package org.eka.tests.common.binarytree;

import java.util.*;

public class BinaryTreeNode<T> {
    public T val;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T x) {
        val = x;
    }

    public BinaryTreeNode(T[] values) {
        if(values.length == 0 || values[0] == null) {
            return;
        }
        this.val = values[0];
        if(values.length > 1) {
            createNextLayer(Arrays.asList(values).subList(1, values.length), Collections.singletonList(this));
        }
    }

    private BinaryTreeNode<T> processValue(T val, List<BinaryTreeNode<T>> list) {
        if(val == null) {
            return null;
        }
        BinaryTreeNode<T> node = new BinaryTreeNode<T>(val);
        list.add(node);
        return node;
    }

    private void createNextLayer(List<T> values, List<BinaryTreeNode<T>> list) {
        List<BinaryTreeNode<T>> childList = new ArrayList<>();
        int i, v;
        for (i = 0, v = 0; v < values.size() && i < list.size(); i++, v = v + 2) {
            list.get(i).left = processValue(values.get(v), childList);
            if (v + 1 < values.size()) {
                list.get(i).right = processValue(values.get(v + 1), childList);
            }
        }
        if (v < values.size()) {
            createNextLayer(values.subList(v, values.size()), childList);
        }
    }

    public List<T> toSortedList() {
        List<T> result = new ArrayList<>();
        result.addAll(Optional.ofNullable(left).map(BinaryTreeNode::toSortedList).orElse(Collections.emptyList()));
        result.add(val);
        result.addAll(Optional.ofNullable(right).map(BinaryTreeNode::toSortedList).orElse(Collections.emptyList()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            String st = toString(queue);
            if(!sb.toString().isEmpty() && !st.isEmpty()) {
                sb.append(',');
            }
            sb.append(st);
        }
        return sb.toString();
    }

    private String toString(Queue<BinaryTreeNode<T>> queue) {
        int size = queue.size();
        StringBuilder sb = new StringBuilder();
        int nullCounts = 0;
        for(int i = 0; i < size; i++) {
            BinaryTreeNode<T> item = queue.poll();
            if(!sb.toString().isEmpty()) {
                sb.append(',');
            }
            if (item == null) {
                nullCounts++;
                sb.append("null");
            } else {
                sb.append(item.val.toString());
                queue.add(item.left);
                queue.add(item.right);
            }
        }
        return nullCounts < size ? sb.toString() : "";
    }
}
