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
    public ListNode mergeKLists(ListNode[] lists) {
     if(lists == null || lists.length==0) return null;

     int interval = 1;
     int n = lists.length;
     while(interval < n ){
        for(int i=0; i+interval < n; i+=interval * 2){
            lists[i] = mergeTwoLists(lists[i],lists[i+interval]);

        }
        interval*=2;
     }

     return lists[0];
    }

private ListNode mergeTwoLists(ListNode a, ListNode b){
    ListNode dummy = new ListNode(-1);
    ListNode tail = dummy;
    while(a!=null && b!= null){
        if(a.val <= b.val){
            tail.next = a;
            a=a.next;
        }
        else{
            tail.next = b;
            b=b.next;
        }
        tail = tail.next;
    }
    tail.next = (a != null) ? a : b;
    return dummy.next;
}

}
