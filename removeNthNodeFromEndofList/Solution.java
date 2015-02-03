package removeNthNodeFromEndofList;

import java.util.Stack;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		Stack<ListNode> path = new Stack<ListNode>();
		ListNode cNode = head;
		path.push(cNode);
		int count = 1;
		while(cNode.next!=null) {
			cNode = cNode.next;
			path.push(cNode);
			count++;
		}
		if(count == n) {
			return head.next;
		}
		for(int i=1; i<n; i++) {
			path.pop();
		}
		ListNode dNode = path.pop();
		ListNode pNode = path.pop();
		pNode.next = dNode.next;
		return head;
    }
}
