package leetcode_LongestPanlindromicSubstring;

public class Solution {
	String postProcess(String s) {
		String s1 = new String();
		for(int i=0; i<s.length(); i++) {
			s1 += '#';
			s1 += s.charAt(i);
			if(i==s.length()-1) {
				s1 += '#';
			}		
		}
		return s1;
	}
	String  maxInt(String s, int[] P) {
		int max = 0, maxIndex = 0;
		for(int i=0; i<P.length; i++) {
			if(max<P[i]) {
				max = P[i];
				maxIndex = i;
			}
		}
		String s2 = new String();
		for(int i=maxIndex-(P[maxIndex]-1); i<=maxIndex+(P[maxIndex]-1); i++) {
			if(s.charAt(i)!='#') {
				s2 += s.charAt(i);
			}
		}
		return s2;
	}
	public String longestPalindrome(String s) {
		if(s==null) {
			return null;
		}
		if(s.length()==1) {
			return s;
		}
		String s1 = postProcess(s);
        int id = 0, mx = 0, len = s1.length();
        int[] P = new int[len];
        // in java default value of int is zero
        for(int i=0; i<len; i++) {
        	if(mx<=i) {
        		P[i] = 1;
        	}
        	else {
        		P[i] = (int)Math.min(P[2*id-i], mx-i);
        	}
        	while(i-P[i]>=0 && i+P[i]<=s1.length()-1 && s1.charAt(i-P[i]) == s1.charAt(i+P[i])) {
        		P[i]++;
        	}
        	if(i+P[i]>mx) {
        		mx = i+P[i];
        		id = i;
        	}
        }
        return maxInt(s1, P);
        //return P;
    }
}
