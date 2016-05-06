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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(res, root, 0);
        //System.out.println(res);
        int sum = 0;
        for(int x:res) {
            sum += x;
        }
        return sum;
    }
    public void helper(ArrayList<Integer> res, TreeNode root, int num) {
        int t = num*10 + root.val;
        if (root.left == null && root.right == null) {
            res.add(t);
            return;
        }
        if (root.left != null){
            helper(res, root.left, t);
        }
        if (root.right != null) {
            helper(res, root.right, t);
        }
        
    }
}