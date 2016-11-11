/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest
 * path from the root node down to the nearest leaf node.
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

    // Divide and conquer
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getMin(root);
    }

    private int getMin(TreeNode node) {
        if (node == null) {    // The only missing children
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {    // Leaf nodes.
            return 1;
        }

        int left = getMin(node.left);
        int right = getMin(node.right);

        return Math.min(left, right) + 1;
    }
}
