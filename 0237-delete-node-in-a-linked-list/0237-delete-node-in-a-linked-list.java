/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

       // direct access to the node is given which needs to be deleted
       // Therefore, in this approach
       // First copy the next node value in the current node
       // Then bypass the next node 
        node.val = node.next.val;
        node.next = node.next.next;      
    }
}