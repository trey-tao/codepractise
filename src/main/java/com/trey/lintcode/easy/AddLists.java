package com.trey.lintcode.easy;

/**
 * 167. 链表求和
 *
 * 你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
 *
 * 样例
 * 样例 1:
 * 	输入: 7->1->6->null, 5->9->2->null
 * 	输出: 2->1->9->null
 *
 * 	样例解释:
 * 	617 + 295 = 912
 * 	912 转换成链表:  2->1->9->null
 *
 *
 * 样例 2:
 * 	输入:  3->1->5->null, 5->9->2->null
 * 	输出: 8->0->8->null
 *
 * 	样例解释:
 * 	513 + 295 = 808
 * 	808 转换成链表: 8->0->8->null
 *
 * @FileName: AddLists.java
 * @Description: AddLists.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/25 20:43
 */
public class AddLists {

	/**
	 * 思路：
	 *     分别遍历两个链表，挨个相加，进位利用一个临时变量存储
	 *
	 * 注意点
	 *      1 临时变量：进位号 需要持续考虑，很容易丢掉
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addLists(ListNode l1, ListNode l2) {
		// 进位临时变量
		int temp = 0;

		ListNode head = new ListNode(0);
		ListNode cur = head;

		/**
		 * 此处可以优化：
		 *      while(l1 != null || l2 != null) {
		 *          // 将三种情况统一处理
		 *      }
		 */
		while (l1 != null && l2 != null) {
			Integer tmp = l1.val + l2.val + temp;
			temp = tmp / 10;
			cur.next = new ListNode(tmp % 10);
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while(l1 != null) {
			Integer tmp = l1.val + temp;
			temp = tmp / 10;
			cur.next = new ListNode(tmp % 10);
			cur = cur.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			Integer tmp = l2.val + temp;
			temp = tmp / 10;
			cur.next = new ListNode(tmp % 10);
			cur = cur.next;
			l2 = l2.next;
		}
		if(temp > 0) {
			cur.next = new ListNode(temp);
		}
		if(head == cur) {
			return head;
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode h1 = new ListNode(9);
		h1.next = new ListNode(9);

		ListNode h2 = new ListNode(9);
//		h2.next = new ListNode(1);

		ListNode result = new AddLists().addLists(h1,h2);
		while (result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
