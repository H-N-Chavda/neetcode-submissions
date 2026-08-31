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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = recurse(head, k);
        return curr;
    }

    private ListNode recurse(ListNode head, int k) {
        if(head == null)    return null;

        ListNode curr = head;
        int count = 0;
        while(curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if(count < k)   
            return head;

        ListNode prev = null;
        curr = head;
        ListNode next = null;
        for(int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = recurse(curr, k);
        return prev;
    }
}
