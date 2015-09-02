package longestValidParentheses;

import java.util.ArrayList;

public class Solution {
	void longestLeft2(String s, int pos, ArrayList<Integer> beg, ArrayList<Integer> end) {
		int tbeg, tend, tmp;
		if(end.isEmpty()) {
			if(pos-1>=0) {
				if(s.charAt(pos-1)=='(') {
					beg.add(pos-1);
					end.add(pos);
				}
			}
		}
		else {
			tbeg = beg.get(beg.size()-1);
			tend = end.get(end.size()-1);
			if(pos-tend==1 && tbeg-1>=0 && s.charAt(tbeg-1)=='(') {			
				tmp = end.indexOf(tbeg-2);
				if(tmp>=0) {
					tmp = beg.get(tmp);
					beg.add(tmp);
					end.add(pos);
				}
				else {
					beg.add(tbeg-1);
					end.add(pos);
				}
			}
			else if(pos-tend==2 && s.charAt(pos-1)=='(') {
				beg.add(tbeg);
				end.add(pos);
			}
			else if(pos-1>=0 && s.charAt(pos-1)=='(') {
				beg.add(pos-1);
				end.add(pos);
			}
		}
	}
	public int longestValidParentheses(String s) {
		ArrayList<Integer> beg = new ArrayList<Integer>();
		ArrayList<Integer> end = new ArrayList<Integer>();
		int start = 0;
		for(; start<s.length(); start++) {
			if(s.charAt(start)=='(') {
				break;
			}
		}
		System.out.println("start: "+start);
		for(; start<s.length(); start++) {
			if(s.charAt(start)==')') {
				break;
			}
		}
		if(start>=s.length()) {
			return 0;
		}
		System.out.println("start: "+start);
		for(int i=start; i<s.length(); i++) {
			if(s.charAt(i)==')') {
				longestLeft2(s, i, beg, end);
			}
		}
		System.out.println(beg);
		System.out.println(end);
		int max = 0;
		for(int i=0; i<beg.size(); i++) {
			if(end.get(i)-beg.get(i)+1>max) {
				max = end.get(i)-beg.get(i)+1;
			}
		}
		return max;
    }
}
