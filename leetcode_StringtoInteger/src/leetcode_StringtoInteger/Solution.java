package leetcode_StringtoInteger;

import java.util.ArrayList;

public class Solution {
	public int digits(char a) {
		if(a=='0') {
			return 0;
		}
		else if (a=='1') {
			return 1;
		}
		else if (a=='2') {
			return 2;
		}
		else if (a=='3') {
			return 3;
		}
		else if (a=='4') {
			return 4;
		}
		else if (a=='5') {
			return 5;
		}
		else if (a=='6') {
			return 6;
		}
		else if (a=='7') {
			return 7;
		}
		else if (a=='8') {
			return 8;
		}
		else{
			return 9;
		}
	}
	boolean exceed(ArrayList<Integer> a, int[] max) {
		if(a.size()<max.length) {
			return false;
		}
		else if(a.size()>max.length) {
			return true;
		}
		else {
			for(int i=0; i<a.size(); i++) {
				if(a.get(i)<max[i]) {
					return false;
				}
				else if(a.get(i)>max[i]) {
					return true;
				}
			}
		}
		return false;
	}
	public int atoi(String str) {
		if(str == null) {
			return 0;
		}
		else {
			int[] INT_MAX = new int[] {2,1,4,7,4,8,3,6,4,7};
			int[] INT_MIN = new int[] {2,1,4,7,4,8,3,6,4,8};
			boolean start = false;
			boolean sign = true;
			boolean valid = true;
			char tmp;
			ArrayList<Integer> digits = new ArrayList<Integer>();
			for(int i=0; i<str.length(); i++) {
				tmp = str.charAt(i);
				if(start == false && tmp!=' ') {
					start = true;
					if(tmp == '+') {
						sign = true;
					}
					else if(tmp == '-'){
						sign = false;
					}
					else if(tmp>='0' && tmp<='9') {
						digits.add(digits(tmp));
					}
					else {
						valid = false;
						break;
					}
				}
				else if(start == true) {
					if(tmp>='0' && tmp<='9') {
						digits.add(digits(tmp));
					}
					else {
						break;
					}
				}
			}
			if(valid == false || digits.size()==0) {
				return 0;
			}
			else if(sign) {
				//System.out.println(digits);
				//System.out.println(exceed(digits, INT_MAX));
				if(exceed(digits, INT_MAX)) {
					return 2147483647;
				}
				else {
					int sum = 0;
					int pow = 1;
					for(int i = digits.size()-1; i>=0; i--) {
						sum += digits.get(i)*pow;
						pow *= 10;
						//System.out.println();
					}
					return sum;				
				}
				
			}
			else {
				if(exceed(digits, INT_MIN)) {
					return -2147483648;
				}
				else {
					int sum = 0;
					int pow = 1;
					for(int i = digits.size()-1; i>=0; i--) {
						sum -= digits.get(i)*pow;
						pow *= 10;
						//System.out.println();
					}
					return sum;				
				}				
			}
		}     
    }
}
