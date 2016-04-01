//160. Intersection of Two Linked Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)    return null;
        ListNode a = headA;
        ListNode b = headB;
        
        ListNode aTail = null;
        ListNode bTail = null;
        while(true){
            if(a == null){
                a = headB;
            }
            if(b == null){
                b = headA;
            }
            if(a.next == null){
                aTail = a;
            }
            if(b.next == null){
                bTail = b;
            }
            if(aTail != null && bTail != null && aTail != bTail){
                return null;
            }
            if(a == b)  return a;
            a = a.next;
            b = b.next;
        }
        
    }
}