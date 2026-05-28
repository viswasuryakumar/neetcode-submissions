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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        if(fast==null){
            return head.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow=slow.next;
        }
        slow.next = slow.next.next;
        return head;
        /*
int length = 0;
        ListNode temp = head;

        // First pass: calculate length of list
        while (temp != null) {
            length++;  
            temp = temp.next;
        }

        // If we need to remove the head
        if (length == n) {
            return head.next;
        }

        // Second pass: find the (length - n)th node
        temp = head;
        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }

        // Remove the node
        temp.next = temp.next.next;
        return head;
*/
    }

}
