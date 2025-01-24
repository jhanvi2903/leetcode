/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        ListNode move = head;
        int length = 0;

        if(head == null || head.next == null) return head;
        
        // Find the length & the tail
        while(move != null) {
            length++;
            tail = move;
            move = move.next;
        }
        
        k = k % length; // k % length is required when k > length

        // if k evaluates to 0, means no rotation. Return head
        if(k == 0) return head;

        // find the position to stop before the node which will be rotated
        int stop = length - k; 
        int mover = 1;

        // Traverse until we reach the stop node
        ListNode temp = head;
        while(mover != stop){
             temp = temp.next;
             mover++;
        }

        ListNode hold = temp.next; // hold the starting node from where the rotation starts
        temp.next = null; // Disconnect and point to null
        tail.next = head; // Point tail's next to head
        head = hold; // New head

        return head;
    }
}