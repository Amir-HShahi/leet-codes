class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) 
            return null;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }
    }
}