package mergekSortedLists;

import java.util.Comparator;

public class ListNodeCompare implements Comparator<ListNode>{
	@Override
	public int compare(ListNode o1, ListNode o2) {
		// TODO Auto-generated method stub
		if(o1.val==o2.val) {
			return 0;
		}
		else if(o1.val>o2.val) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
