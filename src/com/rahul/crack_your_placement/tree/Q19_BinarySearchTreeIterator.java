package com.rahul.crack_your_placement.tree;

import java.util.Stack;

public class Q19_BinarySearchTreeIterator {
    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    static class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            stack.add(root);
        }

        public int next() {
            TreeNode peek;
            while ((peek = stack.peek()).left != null || peek.right != null) {
                stack.pop();

                if (peek.right != null)
                    stack.add(peek.right);

                stack.add(peek);

                if (peek.left != null)
                    stack.add(peek.left);

                peek.left = peek.right = null;
            }
            return stack.pop().val;
        }

        public boolean hasNext() {
            return !stack.empty();
        }
    }

}
