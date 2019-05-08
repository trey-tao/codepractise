package com.trey.lintcode.easy;


/**
 *  93. 平衡二叉树
 *
 *  描述
 * 给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。
 *
 * 样例
 * 样例  1:
 * 	输入: tree = {1,2,3}
 * 	输出: true
 *
 * 	样例解释:
 * 	如下，是一个平衡的二叉树。
 * 		  1
 * 		 / \
 * 		2  3
 *
 *
 * 样例  2:
 * 	输入: tree = {3,9,20,#,#,15,7}
 * 	输出: true
 *
 * 	样例解释:
 * 	如下，是一个平衡的二叉树。
 * 		  3
 * 		 / \
 * 		9  20
 * 		  /  \
 * 		 15   7
 *
 *
 * 样例  2:
 * 	输入: tree = {1,#,2,3,4}
 * 	输出: false
 *
 * 	样例解释:
 * 	如下，是一个不平衡的二叉树。1的左右子树高度差2
 * 		  1
 * 		   \
 * 		   2
 * 		  /  \
 * 		 3   4
 *
 * @FileName: BalanceTree.java
 * @Description: BalanceTree.java类说明
 * @Author: tao.shi
 * @Date: 2019/2/22 13:48
 */
public class BalanceTree {

	/**
	 * 思路：
	 *      平衡二叉树的判断标准就是左子树的高度 和 右子树的高度 相差不超过1
	 *      但是如果左子树或者右子树本身都已经不平衡了，就不需要比较了，
	 *      所以对于一个课的高度，设置为两个：真实高度  和 -1
	 *      -1 表示的是 该树节点 内部不平衡
	 *      所以判断root是否平衡有两个标准：
	 *          | 左子树的高度-右子树的高度 | < 1
	 *          左子树的高度为-1
	 *          右子树的高度为-1
	 * @param root: The root of binary tree.
	 * @return: True if this Binary tree is Balanced, or false.
	 */
	public boolean isBalanced(TreeNode root) {
		// write your code here
		return maxDepth(root) != -1;
	}

	private int maxDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int l = maxDepth(node.left);
		int r = maxDepth(node.right);
		if( l == -1 || r == -1
		|| Math.abs(l-r) >1 ) {
			return -1;
		}
		return Math.max(l,r) + 1;
	}


	public class TreeNode {
	      public int val;
	      public TreeNode left, right;
	      public TreeNode(int val) {
	          this.val = val;
	          this.left = this.right = null;
	      }
	}

	public static void main(String[] args) {

	}

}
