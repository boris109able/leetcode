package reverseNodesinkGroup;

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
	static ListNode conK(int k) {
		ListNode head = new ListNode(1);
		ListNode cNode = head;
		for(int i=2; i<=k; i++)
		{
			ListNode newNode = new ListNode(i);
			cNode.next = newNode;
			cNode = cNode.next;
		}
		return head;
	}
	public static void main(String[] args)
	{
		int k = 4;
		ListNode head = conK(10);
		//printListNode(head);
		Solution sol = new Solution();
		/*ListNode beg = head;
		ListNode end = sol.findEnd(beg, k);
		ListNode prev = null;
		ListNode next = end.next;*/
		//printListNode(beg);
		//printListNode(end);
		//printListNode(prev);
		//printListNode(next);
		//head = end;
		//sol.ListNodeSwapK(4, beg, end, prev, next);
		//System.out.print("New List: ");
		//printListNode(head);
		//System.out.println(sol.findEnd(head, k).val);
		//System.out.print("reversed group: ");
		printListNode(sol.reverseKGroup(head, k));
	}
}
