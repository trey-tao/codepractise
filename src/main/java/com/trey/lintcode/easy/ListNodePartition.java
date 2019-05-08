package com.trey.lintcode.easy;

/**
 * 96. 链表划分
 * 描述
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
 *
 * 你应该保留两部分内链表节点原有的相对顺序。
 *
 * 样例
 * 样例  1:
 * 	输入: list = null, x = 0
 * 	输出: null
 *
 * 	样例解释:
 * 	空链表本身满足要求
 *
 *
 * 样例 2:
 * 	输入: list = 1->4->3->2->5->2->null, x = 3
 * 	输出: 1->2->2->4->3->5->null
 *
 * 	样例解释:
 * 	要保持原有的相对顺序。
 *
 * @FileName: ListNodePartition.java
 * @Description: ListNodePartition.java类说明
 * @Author: tao.shi
 * @Date: 2019/2/28 18:54
 */
public class ListNodePartition {

	/**
	 * 思路：
	 *  1. 第一次遍历，将x后小于x的节点连接好，保存为tmpNode
	 *  2. 第二次遍历，将tmpNode插入指定位置
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
		// write your code here
		if(head == null) {
			return null;
		}
		ListNode leftNode = new ListNode(0);
		ListNode rightNode = new ListNode(0);

		ListNode left = leftNode;
		ListNode right = rightNode;

		while (head != null) {
			int val = head.val;
			if(val < x) {
				// 先链接到尾部，然后后移一位继续
				left.next = head;
				left = head;
			} else {
				right.next = head;
				right = head;
			}
			head = head.next;
		}
		right.next = null;
		// 把初始化的开头一个节点元素过滤掉
		left.next = rightNode.next;
		return leftNode.next;
	}

}
