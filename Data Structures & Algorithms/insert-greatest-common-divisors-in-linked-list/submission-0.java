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
        ListNode copy = head;
        while(copy.next != null){
            int a = copy.val;
            int b = copy.next.val;
            int gcd = gcd(a,b);
            ListNode originalNext = copy.next;  // Save original next node
            ListNode gcdNode = new ListNode(gcd);

            copy.next = gcdNode;                // Insert GCD node
            gcdNode.next = originalNext;        // Reconnect original node

            copy = originalNext;    
        }
        return head;

        
    }
 public int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}
}