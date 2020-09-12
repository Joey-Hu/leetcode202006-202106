package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/10 9:04
 * @desc: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal2 {

    /**
     * 迭代方法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return res;
        }

        TreeNode cur = root;
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.empty()) {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}