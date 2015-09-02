package insertInterval;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		Interval v1 = new Interval(1,5);
		Interval v2 = new Interval(2,3);
		//Interval v3 = new Interval(6,7);
		//Interval v4 = new Interval(8,9);
		//Interval v5 = new Interval(1,10);
		List<Interval> intervals = new ArrayList<Interval>();
		//intervals.add(v4);
		//intervals.add(v3);
		//intervals.add(v2);
		intervals.add(v1);
		//intervals.add(v5);
		intervals = sol.insert(intervals, v2);
		for(Interval intv: intervals) {
			System.out.println("["+intv.start+","+intv.end+"]");
		}			
	}
}