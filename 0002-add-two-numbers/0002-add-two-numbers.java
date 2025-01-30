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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int sum = 0;
        int carry = 0;
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while(t1 != null || t2 != null || carry != 0){
            sum = carry;

            if(t1 != null){
                sum += t1.val;
                t1 = t1.next;
            }

             if(t2 != null){
                sum += t2.val;
                t2 = t2.next;
            }

            int num = sum % 10; // retrieve 2nd digit
            carry = sum /10;    // store 1st digit

            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return dummy.next;
    }
}