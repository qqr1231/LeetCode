/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode rt;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.rt = root;
        stack = new Stack<TreeNode>();
        while (rt != null) {
            stack.push(rt);
            rt = rt.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
        
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode t = stack.pop();
        if (t.right != null) {
            while (t.right != null) {
                stack.push(t.right);
                t.right = t.right.left;
            }
        }
        return t.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */