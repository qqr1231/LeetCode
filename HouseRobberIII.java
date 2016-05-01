/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // result = max(root, left + right)
    public int rob(TreeNode root) {
        return dfs(root)[0];
        
    }
    public int[]  dfs (TreeNode root) {
        int[] d = {0,0};
        if (root != null) {
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            d[1] = left[0] + right[0];
            d[0] = Math.max(root.val+left[1]+right[1], d[1]);
        }
        return d;
    }
}