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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        ListNode next = curr.next;

        while(next != null) {
            ListNode temp = new ListNode(gcd(curr.val, next.val));
            curr.next = temp;
            temp.next = next;
            curr = next;
            next = next.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        if(a == 0)  return b;
        if(b == 0)  return a;
        if(a > b)   return gcd(a-b, b);
        else        return gcd(a, b-a);
    }
}