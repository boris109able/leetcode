package removeNthNodeFromEndofList;

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
		Solution sol = new Solution();
		ListNode newHead = sol.removeNthFromEnd(head, 1);
		printListNode(newHead);
	}
}
