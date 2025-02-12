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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;

        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        // Decide where the head should point
        if(list1.val <= list2.val) {
           head = tail = list1;
           list1 = list1.next;
        }else {
            head = tail = list2;
            list2 = list2.next;

        }

        // Keep moving tail based on the condition
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            } 
        }

        // Check if any of the list is not traversed, join it by tails next
        if(list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return head;
    }
}