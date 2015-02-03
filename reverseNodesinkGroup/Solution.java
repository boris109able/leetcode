package reverseNodesinkGroup;

public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k==1) {
			return head;
		}
		ListNode beg = head;
		ListNode end = findEnd(beg, k);
		System.out.print("head: ");
		Test.printListNode(head);
		System.out.print("end: ");
		Test.printListNode(end);
		if(end==null) {
			return head;
		}
		head = end;
		ListNode prev = null;
		ListNode next = end.next;
		while(end!=null) {
			Test.printListNode(head);
			ListNodeSwapK(k, beg, end, prev, next);
			prev = beg;
			beg = next;
			end = findEnd(beg, k);
			if(end!=null) {
				next = end.next;
			}
		}
		return head;
    }
	ListNode findEnd(ListNode beg, int k) {
		ListNode cNode = beg; 
		int count = 1;
		while(cNode!=null && count < k) {
			cNode = cNode.next;
			count++;
		}
		if(count<k) {
			return null;
		}
		return cNode;
	}
	void ListNodeSwapK(int k, ListNode beg, ListNode end, ListNode prev, ListNode next) {
		ListNode cc = beg, n1 = beg.next, n2 = n1.next;
		if(prev!=null) {
			prev.next = end;
		}
		beg.next = next;
		//System.out.println("cc: "+cc.val+" n1: "+n1.val+" n2: "+n2.val);
		for(int count=2; count<k; count++) {
			n1.next = cc;
			cc = n1;
			n1 = n2;
			n2 = n2.next;
			System.out.println("cc: "+cc.val+" n1: "+n1.val);
		}
		n1.next = cc;
	}
}
