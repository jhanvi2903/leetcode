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
        

        while(move != null) {
            length++;
            tail = move;
            move = move.next;
        }
        
        k = k % length;
        if(k == 0) return head;
        int stop = length - k;
        int mover = 1;

        ListNode temp = head;
        while(mover != stop){
             temp = temp.next;
             mover++;
        }

        ListNode hold = temp.next;
        temp.next = null;
        tail.next = head;
        head = hold;

        return head;
    }
}