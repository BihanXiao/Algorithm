/**
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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */

    /*
    // Solution 1: Traversal
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        preTraversal(result, root);
        return result;
    }

    private void preTraversal(ArrayList<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preTraversal(result, root.left);
        preTraversal(result, root.right);
    }
    */
    /*
    // Solution 2: Divide and Conquer
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }
    */

    // Solution 3: Non-recursion
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode current;

        if (root == null) {
            return result;
        }

        nodes.push(root);
        while (!nodes.empty()) {
            current = nodes.pop();
            result.add(current.val);

            if (current.right != null) {
                nodes.push(current.right);
            }

            if (current.left != null) {
                nodes.push(current.left);
            }
        }
        return result;
    }
}
