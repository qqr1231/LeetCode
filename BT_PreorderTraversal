/* 144. Binary Tree Preorder Traversal
	
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)    return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode t = root;
        while((!stack.isEmpty()) || t != null){
            if(t != null){
                res.add(t.val);
                if(t.right != null){
                    stack.add(t.right);
                }
                t = t.left;
            }else{
                t = stack.pop();
            }
        }
        return res;
    }
}