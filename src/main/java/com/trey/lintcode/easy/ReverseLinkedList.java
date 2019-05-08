package com.trey.lintcode.easy;

/**
 * 35-翻转链表
 * @FileName: ReverseLinkedList.java
 * @Description: ReverseLinkedList.java类说明
 * @Author: tao.shi
 * @Date: 2019/2/13 10:22
 */
public class ReverseLinkedList {

	/**
	 * 思路：
	 *  对于一个1->2->3->4 这样一个链表，翻转的思路为，遍历链表，将每一位的node依次替换到head，具体步骤：
	 *      1 将节点2替换至头部head，得 2 -> 1 -> 3 -> 4
	 *      2 将节点3替换至头部， 3 -> 2 -> 1 -> 4
	 *      3 将节点4替换至头部， 4 -> 3 -> 2 -> 1
	 *      4 完成
	 * 另外基于java还有思路：
	 *      1、 将链表塞入List，然后Collections.reverse(list)，实现翻转
	 *      2、 将链表遍历放入一个数组，然后从尾部开始遍历生成链表
	 * @param head: n
	 * @return: The new head of reversed linked list.
	 */
	public ListNode reverse(ListNode head) {
		// write your code here
		if( head == null || head.next == null) {
			// 最多只有一个节点
			return head;
		}

		ListNode curNode = head;
		/**
		 * 当前节点curNode始终不变
		 * 将当前节点的下个节点调整到head头部
		 */
		while (curNode.next != null) {
			ListNode temp = curNode.next;
			curNode.next = temp.next;
			temp.next = head;
			head = temp;
		}
		return head;

	}

}
