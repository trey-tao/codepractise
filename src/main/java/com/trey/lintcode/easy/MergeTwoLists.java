package com.trey.lintcode.easy;

/**
 *
 * 165. 合并两个排序链表
 *
 * 将两个排序链表合并为一个新的排序链表
 *
 * 样例
 * 样例 1:
 * 	输入: list1 = null, list2 = 0->3->3->null
 * 	输出: 0->3->3->null
 *
 *
 * 样例2:
 * 	输入:  list1 =  1->3->8->11->15->null, list2 = 2->null
 * 	输出: 1->2->3->8->11->15->null
 *
 * @FileName: MergeTwoLists.java
 * @Description: MergeTwoLists.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/22 16:46
 */
public class MergeTwoLists {

	/**
	 * 思路：
	 *      再创建一个链表result，同时遍历两个链表
	 *      对两个链表的头节点进行比较，哪个小就塞入result中
	 *      全部比较完成后，肯定有一个链表会剩值，把它链接到result尾部即可。
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// write your code here
		ListNode head = new ListNode(0);
		ListNode result = head;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				ListNode tmp = new ListNode(l1.val);
				result.next = tmp;
				l1 = l1.next;
			} else {
				ListNode tmp = new ListNode(l2.val);
				result.next = tmp;
				l2 = l2.next;
			}
			result = result.next;
		}
		while (l1 != null) {
			ListNode tmp = new ListNode(l1.val);
			result.next = tmp;
			result = result.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			ListNode tmp = new ListNode(l2.val);
			result.next = tmp;
			result = result.next;
			l2 = l2.next;
		}
		head = head.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(0);
		node1.next = new ListNode(5);
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(4);
		ListNode result = new MergeTwoLists().mergeTwoLists(node1,node2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
