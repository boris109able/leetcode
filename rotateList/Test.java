package rotateList;

import helperClass.ListNode;

public class Test {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		Solution sol = new Solution();
		ListNode head = sol.rotateRight(n1, 5);
		while(head!=null) {
			System.out.print(head.val+" -> ");
			head=head.next;
		}
		System.out.println("null");
	}
}
