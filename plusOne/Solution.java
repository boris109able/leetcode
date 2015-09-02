package plusOne;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
    	int ld = digits.length, i;
    	for(i=0;i<ld;i++) {
    		if(digits[ld-1-i]!=9) {
    			break;
    		}
    	}
    	System.out.println(i);
    	if(i==ld) {
    		int[] result = new int[ld+1];
			Arrays.fill(result, 0);
			result[0]=1;
			return result;
    	}
    	else {
    		for(int k=0;k<i;k++) {
    			digits[ld-1-k] = 0;
    		}
    		digits[ld-1-i]++;
    		return digits;
    	}    
    }
}
