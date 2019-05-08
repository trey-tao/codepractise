package com.trey.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 66 二叉树的前序遍历
 *
 * 描述
 * 给出一棵二叉树，返回其节点值的前序遍历。
 *
 * 样例
 * 给出一棵二叉树 {1,#,2,3},
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 *  返回 [1,2,3].
 *
 * 挑战
 * 你能使用非递归实现么？
 *
 *
 * @FileName: PreorderTraversal.java
 * @Description: PreorderTraversal.java类说明
 * @Author: tao.shi
 * @Date: 2019/2/18 18:36
 */
public class PreorderTraversal {

	/**
	 * 思路：
	 *
	 * 前序遍历：根结点 ---> 左子树 ---> 右子树
	 *
	 * 中序遍历：左子树---> 根结点 ---> 右子树
	 *
	 * 后序遍历：左子树 ---> 右子树 ---> 根结点
	 *
	 * 层次遍历：只需按层次遍历即可
	 *
	 * 递归最简单，但是性能差些！
	 *
	 *      这里使用的是递归，相似的中序和后序都一个思路。
	 *      其他思路：
	 *          使用深度优先遍历
	 *
	 * @param root: A Tree
	 * @return: Preorder in ArrayList which contains node values.
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		// write your code here
		if(root == null) {
			return new ArrayList<>();
		}
		List<Integer> result  = new ArrayList<>();
		result.add(root.val);
		if(root.left != null) {
			result.addAll(preorderTraversal(root.left));
		}
		if(root.right != null) {
			result.addAll(preorderTraversal(root.right));
		}
		return result;
	}

	public static class TreeNode {
		public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
             this.val = val;
              this.left = this.right = null;
         }
	}

}
