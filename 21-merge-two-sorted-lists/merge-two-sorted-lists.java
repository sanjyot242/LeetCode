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
        ListNode ans = new ListNode(0);
        ListNode last = ans;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                last.next = list2;
                list2 = list2.next;
            }else{
                last.next = list1;
                list1 = list1.next;
            }
            last = last.next;
        }
        
        if(list1==null){
            last.next = list2;
        }else{
            last.next = list1;
        }
        return ans.next;
    }
}