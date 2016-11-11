/**
 * Given a binary tree, determine if it is height-balanced.
 * FOR THIS PROBLEM, a height-balanced binary tree is defined as
 * a binary tree in which the DEPTH(MAXMUM HEIGHT) OF THE TWO SUBTREES OF EVERY NODE
 * never differ by more than 1.
 * 
 * It is not a typical balanced tree.
 * 
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

import java.lang.Math;
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    class ResultType {    // Inner class do not need access specifier.
        final boolean balance;
        final int maxDepth;

        ResultType(boolean balance, int maxDepth) {    // No need to declare as public...why?
            this.balance = balance;
            this.maxDepth = maxDepth;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;    // In this question, empty is seen as balanced.
        }

        ResultType result = checkBalance(root);

        return result.balance;
    }

    private ResultType checkBalance(TreeNode node) {
        if (node == null) {
            return new ResultType(true, 0);
        }

        ResultType left = checkBalance(node.left);
        ResultType right = checkBalance(node.right);

        if (!left.balance || !right.balance) {
            return new ResultType(false, -1);
        }

        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }   
}
