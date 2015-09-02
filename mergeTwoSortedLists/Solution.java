package mergeTwoSortedLists;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) {
			return l2;
		}
		if(l2==null) {
			return l1;
		}
		ListNode head;
		if(l1.val<l2.val) {
			head = l1;
			l1 = l1.next;
		}
		else {
			head = l2;
			l2 = l2.next;
		}
		ListNode pos = head;
		while(l1!=null && l2!=null) {
			//System.out.println(pos.val);
			if(l1.val<l2.val) {
				pos.next = l1;
				pos = pos.next;
				l1 = l1.next;
			}
			else {
				pos.next = l2;
				pos = pos.next;
				l2 = l2.next;
			}
		}	
		if(l1==null && l2!=null) {
			pos.next = l2;
		}
		if(l2==null && l1!=null) {
			pos.next = l1;
		}
		return head;       
    }
	public void printListNode(ListNode l) {
		while(l!=null) {
			System.out.print(l.val+"->");
			l = l.next;
		}
		System.out.println();
	}
}
