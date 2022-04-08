/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author chendong09
 * @since 2022/04/08
 */
public class Q19 {

    /**
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while (n > 0) {
            if (fast != null) {
                fast = fast.next;
            }
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }
}
