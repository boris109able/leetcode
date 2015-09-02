package mergekSortedLists;

import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	public ListNode mergeKLists(List<ListNode> lists) {
		ListNodeCompare comp1 = new ListNodeCompare();
		for(int i=0; i<lists.size(); i++) {
			if(lists.get(i)==null) {
				lists.remove(i);
				i--;
			}
		}
		int k = lists.size();
		if(lists.isEmpty()) {
			return null;
		}	 
		if(k==1) {
			return lists.get(0); 
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(comp1);
		ListNode tmp1;
		for(int i=0; i<k; i++) {
			tmp1 = lists.get(i);
			lists.set(i, tmp1.next);
			heap.offer(tmp1);
		}
		ListNode head = heap.poll();
		if(head.next!=null) {
			heap.add(head.next);
		}	
		ListNode cNode = head;
		while(!heap.isEmpty()) {	
			tmp1 = heap.poll();
			if(tmp1.next!=null) {
				heap.add(tmp1.next);
			}
			cNode.next = tmp1;
			cNode = tmp1;
		} 
		return head;
    }
}
