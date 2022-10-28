package org.eka.tests.common.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    public T val;
    public TreeNode<T> parent;
    public List<TreeNode<T>> children = new ArrayList<>();

    public TreeNode(T x, TreeNode<T> parent) {
        this.val = x;
        this.parent = parent;
    }

    public TreeNode(T x) {
        this(x, null);
    }

    public TreeNode<T> createChild(T x) {
        TreeNode<T> child = new TreeNode<>(x, this);
        this.children.add(child);
        return child;
    }
}
