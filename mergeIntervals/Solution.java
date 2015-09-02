package mergeIntervals;

import java.util.*;

public class Solution {
	public class intComparator implements Comparator<Interval> {
		public int compare(Interval intv1, Interval intv2) {
			if(intv1.start>intv2.start) {
				return 1;
			}
			else if(intv1.start<intv2.start) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
	public List<Interval> merge(List<Interval> intervals) {
		intComparator intcomp = new intComparator();
		Collections.sort(intervals, intcomp);
		int n = intervals.size();
		Interval intv1, intv2;
		for(int i=0; i<n-1; i++) {
			intv1 = intervals.get(i);
			intv2 = intervals.get(i+1);
			if(intv1.end>=intv2.start) {
				intervals.remove(i);
				intervals.get(i).start = intv1.start;
				intervals.get(i).end = Math.max(intv1.end, intv2.end);
				n--;
				i--;
			}
			for(Interval intv: intervals) {
				System.out.println("["+intv.start+","+intv.end+"]");
			}	
			System.out.println("---------------------------------");
		}
        return intervals;
    }
}
