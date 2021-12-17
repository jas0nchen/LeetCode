/**
 * 反转链表
 *
 * 1 -> 2 -> 3 -> 4  to  4 -> 3 -> 2 -> 1
 * 时间复杂度O(n)，空间复杂度O(1)
 *
 *
 * @author chendong09
 * @since 2021/12/07
 **/
public class Q206 {

    /**
     * @param head 链表
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return cur;
    }
}
