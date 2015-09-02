package rotateList;

import helperClass.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {   	
        if(head==null) {
        	return head;
        }
        ListNode c = head;
        int n=1;
        while(c.next!=null) {
        	c=c.next;
        	n++;
        }
        k = k%n;
        if(k==0) {
        	return head;
        }
        //System.out.println(n);
        ListNode tail = c;
        //System.out.println(tail.val);
        int ind = n-k;
        c = head;
        //System.out.println(head.val);
        //System.out.println(tail.val);
        for(int i=0;i<ind-1;i++) {
        	c=c.next;
        }
        System.out.println(c.val);
        ListNode l=c;
        ListNode r=c.next;
        l.next=null;
        tail.next=head;
        return r;
    }
}
