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
     * @return: Postorder in ArrayList which contains node values.
     */
    /*
    // Traversal
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
    */
    /*
    // Divide and Conquer
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);

        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    }
    */

    // Non-recursion
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;

        if (root == null) {
            return result;
        }

        nodes.push(current);
        while (!nodes.empty()) {
            current = nodes.peek();
            if (prev == null || prev.left == current || prev.right == current) {    // travel down the tree
                if (current.left != null) {
                    nodes.push(current.left);
                } else if (current.right != null) {
                    nodes.push(current.right);
                }
            } else if (current.left == prev) {    // travel up the tree
                if (current.right != null) {
                    nodes.push(current.right);
                }
            } else {    // include two types of situations: current.right == prev, current == prev (from current.right == null) // if we write this seperately, we will exceed time limit.
                result.add(current.val);
                nodes.pop();
            }
            prev = current;
        }

        return result;
    }
}
