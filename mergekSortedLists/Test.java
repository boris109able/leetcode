package mergekSortedLists;

import java.util.*;

public class Test {
		static void printListNode(ListNode head) {
			if(head!=null) {
				ListNode cNode = head;
				while(cNode!=null) {
					System.out.print(cNode.val+"->");
					cNode = cNode.next;
				}
				System.out.println();
			}
			else {
				System.out.println("Empty ListNode!");
			}
		}
		public static void main(String[] args)
		{
			ListNode head = new ListNode(1);
			ListNode cNode = head;
			for(int i=2; i<=5; i++)
			{
				ListNode newNode = new ListNode(i);
				cNode.next = newNode;
				cNode = cNode.next;
			}
			printListNode(head);
			List<ListNode> lists = new ArrayList<ListNode>();
			lists.add(head);
			head = new ListNode(-5);
			lists.add(head);
			cNode = head;
			for(int i=2; i<=5; i++)
			{
				ListNode newNode = new ListNode(-6+i);
				cNode.next = newNode;
				cNode = cNode.next;
			}
			printListNode(head);
			Solution sol = new Solution();
			ListNode newHead = sol.mergeKLists(lists);
			printListNode(newHead);
			
			List<ListNode> lists2 = new ArrayList<ListNode>();
			lists2.add(null); lists2.add(null);
			System.out.println(lists2.isEmpty());
		}
}
