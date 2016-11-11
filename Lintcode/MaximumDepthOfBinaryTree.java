/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest
 * path from the root node down to the farthest leaf node.
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
     * @return: An integer.
     */

    // Traverse

    private int depth;
    public int maxDepth(TreeNode root) {
        depth = 0;

        maxDepthHelper(root, 1);

        return depth;
    }

    private void maxDepthHelper(TreeNode node, int curDepth) {    // pass by value!!! int is a primary type. Does not like ArrayList<Integer> result.
        if (node == null) {
            return;
        }

        if (curDepth > depth) {
            depth = curDepth;
        }

        maxDepthHelper(node.left, curDepth + 1);
        maxDepthHelper(node.right, curDepth + 1);
    }
    /*
    // Divide and Conquer
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
    */
}
