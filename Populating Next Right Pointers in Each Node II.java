/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)   return;
        
        TreeLinkNode rootNext = root.next;
        TreeLinkNode next = null;
        
        while (rootNext != null) {
            if (rootNext.left != null){
                next = rootNext.left;
                break;
            }else if (rootNext.right != null) {
                next = rootNext.right;
                break;
            }else {
                rootNext = rootNext.next;
            }
        }
        if (root.right != null) {
            root.right.next = next;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            }else {
                root.left.next = next;
            }
        }
        connect(root.right);
        connect(root.left);
    }
}