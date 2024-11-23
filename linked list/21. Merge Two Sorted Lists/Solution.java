
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        mergedList.val = list1.val > list2.val ? list2.val : list1.val;
        ListNode key = mergedList;
        while (list1 != null || list2 != null) {
            ListNode newNode = new ListNode();
            if ((list2 != null && list1 == null) || list1.val > list2.val) {
                newNode.val = list2.val;
                list2 = list2.next;
            } else {
                newNode.val = list1.val;
                list1 = list1.next;
            }
            key.next = newNode;
            key = newNode;
        }
        return mergedList;
    }
}