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
        ListNode ans = new ListNode();
        ListNode dummy = ans;
        int carry = 0;

        while(l1 != null || l2 != null) {
            ans.next = new ListNode();
            ans = ans.next;
            ans.val = carry;
            if(l1 != null)  ans.val += l1.val;
            if(l2 != null)  ans.val += l2.val;
            carry = ans.val/10;
            ans.val = ans.val%10;

            if(l1 != null)  l1 = l1.next;
            if(l2 != null)  l2 = l2.next;
        }

        if(carry > 0)
            ans.next = new ListNode(carry);

        return dummy.next;
    }
}
