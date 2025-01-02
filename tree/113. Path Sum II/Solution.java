import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private List<List<Integer>> pathSumLists = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return pathSumLists;
        }
        ArrayList<Integer> init = new ArrayList<Integer>();
        init.add(root.val);
        DepthFirstSearch(root, targetSum, new ArrayList<>());
        return pathSumLists;
    }

    private void DepthFirstSearch(TreeNode root, int targetSum, List<Integer> tracker) {
        if (root == null)
            return;

        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            tracker.add(root.val);
            pathSumLists.add(tracker);
            return;
        }

        tracker.add(root.val);
        DepthFirstSearch(root.left, targetSum, new ArrayList<Integer>(tracker));
        DepthFirstSearch(root.right, targetSum, new ArrayList<Integer>(tracker));
    }
}