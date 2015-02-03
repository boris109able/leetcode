package swapNodesinPairs;

public class Solution {
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
		for(int count=2; count<k; count++) {
			n1.next = cc;
			cc = n1;
			n1 = n2;
			n2 = n2.next;
		}
		n1.next = cc;
	}
	public ListNode swapPairs(ListNode head) {
		int k=2;
		ListNode beg = head;
		ListNode end = findEnd(beg, k);
		if(end==null) {
			return head;
		}
		head = end;
		ListNode prev = null;
		ListNode next = end.next;
		while(end!=null) {
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
}
