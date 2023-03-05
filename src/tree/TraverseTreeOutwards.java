package tree;

import java.util.*;

public class TraverseTreeOutwards {
    // https://leetcode.com/discuss/interview-question/2528777/Amazon-or-L5-or-Bangalore-or-Aug-2022
    // level order search

    public List<List<Integer>> levelOrderOutwards(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        if (root == null) {
            return result;
        }
        q.add(root);
        q.add(null);

        List<Integer> rootTemp = new ArrayList<Integer>();
        rootTemp.add(root.val);
        result.add(rootTemp);

        while (q.size() > 0) {
            TreeNode temp = q.poll();
            if (temp != null) {
                if (temp.right != null) {
                    level.add(temp.right.val);
                    q.add(temp.right);
                }
                if (temp.left != null) {
                    level.add(temp.left.val);
                    q.add(temp.left);
                }
            } else {
                // null encountered indicates that level is done;
                List<Integer> copy = new ArrayList<>(level);
                    if (!copy.isEmpty()) {
                        result.add(copy);
                    }
                    level.clear();
                if (!q.isEmpty()) {
                    // indicate this level is over
                    q.add(null);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(13);
        root.right.left.left = new TreeNode(12);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        System.out.println(new TraverseTreeOutwards().levelOrderOutwards(root));
    }

}
