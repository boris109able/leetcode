package permutationSequence;

import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
    	k = k-1;
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        for(int i=0;i<n;i++) {
        	candidates.add(i+1);
        }
        int prod = 1;
        for(int i=1;i<n;i++) {
        	prod *= i;
        }
        String result = new String();
        int digit, ith;
        for(int i=0;i<n;i++) {
        	ith = k/prod;
        	k = k%prod;
        	digit = candidates.get(ith);
        	candidates.remove(ith);
        	result += Integer.toString(digit);
        	if(i<n-1)
        	 {prod /= (n-i-1);}
        }
        return result;
    }
}
