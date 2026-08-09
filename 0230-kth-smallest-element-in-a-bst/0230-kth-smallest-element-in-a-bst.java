/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int count;
    public static int ans;
    public static void sol(TreeNode root,int k){
     if(root==null) return;
     sol(root.left,k);
     count++;
     if(count==k) ans=root.val;
     sol(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        count=0;
        ans=-1;
        sol(root,k);
        return ans;
    }
}