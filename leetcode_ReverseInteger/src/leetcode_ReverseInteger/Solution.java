package leetcode_ReverseInteger;

import java.util.ArrayList;

public class Solution {
	public int reverse(int x) {
		if(x==0) {
			return 0;
		}
		else {
			ArrayList<Integer> digits = new ArrayList<Integer>();
			int y = (x>0)? x:(-x), tmp1, tmp2; 
			while(y>0) {
				tmp1 = y%10;
				tmp2 = (y-tmp1)/10;
				digits.add(tmp1);
				y = tmp2;
			}
			int sum = 0;
			int pow = 1;
			for(int i = digits.size()-1; i>=0; i--) {
				sum += digits.get(i)*pow;
				pow *= 10;
			}
			return (x>0)? sum:(-sum);
		}
        
    }

}
