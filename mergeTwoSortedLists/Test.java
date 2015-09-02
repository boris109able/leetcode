package mergeTwoSortedLists;

public class Test {	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-10);
		ListNode l2 = new ListNode(1);
		ListNode pos1 = l1;
		ListNode pos2 = l2;
		int i=0;
		int v1,v2;
		while(i<9) {
			v1 = pos1.val;
			pos1.next = new ListNode(v1+2);
			pos1 = pos1.next;
			v2 = pos2.val;
			pos2.next = new ListNode(v2+1);
			pos2 = pos2.next;
			i++;
		}
		Solution sol = new Solution();
		ListNode result = sol.mergeTwoLists(l1,l2);
		sol.printListNode(l1);
		sol.printListNode(l2);
		sol.printListNode(result);
	}
}
