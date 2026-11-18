
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return divide(lists, 0, lists.length - 1);
    }
    ListNode divide(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        int mid = left + (right - left) / 2;
        ListNode first = divide(lists, left, mid);
        ListNode second = divide(lists, mid + 1, right);
        return merge(first, second);
    }
    ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }
        current.next = (a != null) ? a : b;
        return dummy.next;
    }
}
