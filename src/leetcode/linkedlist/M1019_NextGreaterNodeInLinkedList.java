package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/10/3 10:10
 * @desc: https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class M1019_NextGreaterNodeInLinkedList {

    /**
     * 单调栈
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        // 从头开始遍历
        for (int i = 0; i < list.size(); i++) {
            // 如果后面存在比栈中索引指代的数更大的数，则索引出栈并给结果数组赋值
            while (!stack.empty() && list.get(stack.peek()) < list.get(i)) {
                res[stack.pop()] = list.get(i);
            }
            // 入栈
            stack.push(i);
        }
        return res;
    }

    class ListNode {
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
