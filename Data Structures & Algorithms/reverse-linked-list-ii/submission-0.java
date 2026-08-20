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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);

        ListNode start = dummy;

        for(int i = 1; i < left; i++)
            start = start.next;

        ListNode curr = start.next;
        ListNode prev = null;

        for(int i = left; i <= right; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        start.next.next = curr;
        start.next = prev;

        return dummy.next;
    }
}