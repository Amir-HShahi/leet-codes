class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode key = mergedList;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                key.next = list1;
                list1 = list1.next;
            } else {
                key.next = list2;
                list2 = list2.next;
            }
            key = key.next;
        }
        key.next = list1 == null ? list2 : list1;
        return mergedList.next;
    }
}