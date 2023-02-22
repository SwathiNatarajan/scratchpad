package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeProblems {

    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null)
            return result;
        // store in queue
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        q.add(null);
        List<Integer> level0 = new ArrayList<>();
        level0.add(root.val);
        result.add(level0);
        List<Integer> level = new ArrayList<Integer>();
        while (q.size() > 0) {
            TreeNode node = q.poll();
            if (node != null) {
                if (node.left != null) {
                    q.add(node.left);
                    level.add(node.left.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                    level.add(node.right.val);
                }
            } else {
                List<Integer> doneLevel = new ArrayList<Integer>();
                doneLevel.addAll(level);
                level.clear();
                if (doneLevel.size() > 0) {
                    result.add(doneLevel);
                }
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
        return result;
    }

    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
    public int maxDepth(TreeNode root) {
        int count = 0;

        if (root == null)
            return count;

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        q.add(null);
        List<Integer> level0 = new ArrayList<>();
        level0.add(root.val);
        ++count;
        List<Integer> level = new ArrayList<Integer>();
        while (q.size() > 0) {
            TreeNode node = q.poll();
            if (node != null) {
                if (node.left != null) {
                    q.add(node.left);
                    level.add(node.left.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                    level.add(node.right.val);
                }
            } else {
                if (level.size() > 0) {
                    ++count;
                }
                level.clear();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
        return count;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = maxDepthRecursive(root.left);
        int rDepth = maxDepthRecursive(root.right);
        return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
    }


    private int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int lMax = findMax(root.left);
        int rMax = findMax(root.right);
        return Math.max(root.val, Math.max(lMax, rMax));
    }

    private int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int lMax = findMin(root.left);
        int rMax = findMin(root.right);
        return Math.min(root.val, Math.min(lMax, rMax));
    }


    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && findMax(root.left) >= root.val) {
            return false;
        }
        if (root.right != null && findMin(root.right) <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isSym(TreeNode leftTreeNode, TreeNode rightTreeNode) {
        if (leftTreeNode == null && rightTreeNode == null) {
            return true;
        }
        if (leftTreeNode == null || rightTreeNode == null) {
            return false;
        }
        if (leftTreeNode.val != rightTreeNode.val) {
            return false;
        }
        return isSym(leftTreeNode.left, rightTreeNode.right) &&
                isSym(leftTreeNode.right, rightTreeNode.left);
    }


    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
    public boolean isSymmetricOrMirror(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSym(root.left, root.right);
    }


    //  https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/
    // Input: nums = [-10,-3,0,5,9]
    // Output: [0,-3,9,-10,null,5]
    private TreeNode sortIt(int start, int end, int[] nums) {
        // overflow condition
        if (start > end) {
            return null;
        }
        int median = (start + end) / 2;
        TreeNode root = new TreeNode(nums[median]);

        root.left = sortIt(start, median - 1, nums);
        root.right = sortIt(median + 1, end, nums);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        // find the median
        // odd array , even array
        // until median, put on left
        // beyond median , put on right
        return sortIt(0, nums.length - 1, nums);
    }
}


