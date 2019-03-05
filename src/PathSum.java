/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1


Return:

[
   [5,4,11,2],
   [5,8,4,5]
]


 */

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    private List<List<Integer>> results;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();

        results = new ArrayList<>();
        pathSum(root, sum, new ArrayList<>());
        return results;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        int remainder = sum - root.val;
        if (remainder == 0 && root.left == null && root.right == null) {
            List<Integer> tempList = new ArrayList<>();
            for (int i : result)
                tempList.add(i);
            results.add(tempList);
        }
        pathSum(root.left, remainder, result);
        pathSum(root.right, remainder, result);

        result.remove(result.size() - 1);
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
