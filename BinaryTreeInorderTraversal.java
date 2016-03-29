/*  94. Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        res = dfs(root,res);
        return res;
    }
    public List<Integer> dfs(TreeNode root,List<Integer> res){
        if (root == null)   return res;
        if (root.left != null){
             dfs(root.left,res);
        }     
        res.add(root.val);
        if (root.right != null){
            dfs(root.right,res);
            
        }
        return res;
    }
}