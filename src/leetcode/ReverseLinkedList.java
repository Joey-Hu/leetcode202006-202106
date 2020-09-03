package leetcode;

/**
 * @author: huhao
 * @time: 2020/9/1 22:22
 * @desc: https://leetcode.com/problems/reverse-linked-list/
 * 递归方法逆转链表动画演示  https://www.youtube.com/watch?v=MRe3UsRadKw
 */
public class ReverseLinkedList {
    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 尾结点变头结点
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
