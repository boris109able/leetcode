package insertInterval;

import java.util.*;

public class Solution {
	public class intCompare implements Comparator<Interval> {
		public int compare(Interval v1, Interval v2) {
			if(v1.start>v2.start) {
				return 1;
			}
			else if (v1.start<v2.start) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intCompare intC = new intCompare();
		int i=0;
		//Collections.sort(intervals, intC);
		for(;i<intervals.size();i++) {
			if(intC.compare(newInterval, intervals.get(i))<0) {
				break;
			}
		}
		//System.out.println(i);
		intervals.add(i, newInterval);
		Interval v1, v2;
		int j;
		if(i==0) {
			j=i;
		}
		else {
			j=i-1;
		}
		for(; j<intervals.size()-1;j++) {
			v1 = intervals.get(j);
			v2 = intervals.get(j+1);
			if(v1.end>=v2.start) {
				v2.start = v1.start;
				v2.end = Math.max(v1.end, v2.end);
				intervals.remove(j);
				j--;
			}
		}
		return intervals;
    }
}