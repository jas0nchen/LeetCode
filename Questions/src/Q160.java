/**
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 输入：listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
 * 输出：Intersected at '1'
 * 解释：相交节点的值为 1 （注意，如果两个链表相交则不能为 0）。
 *
 * @author chendong09
 * @since 2021/12/23
 **/
public class Q160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
