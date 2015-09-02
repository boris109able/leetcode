package leetcode_LongestCommonPrefix;

public class Solution {
	int longestCommon(String a, int n, String b) {
		int i;
		for(i=0; i<n && i<b.length(); i++) {
			if(a.charAt(i)!=b.charAt(i)) {
				break;
			}
		}
		return i;
	}
	public String longestCommonPrefix(String[] strs) {
		if(strs==null) {
			return null;
		}
		else if(strs.length==0) {
			String a = new String();
			return a;
		}
		else if(strs.length==1) {
			return strs[0];
		}
		else {
			String tmp = strs[0];
			int maxT = strs[0].length();
			for(int i=1; i<strs.length; i++) {
				maxT = longestCommon(tmp, maxT, strs[i]);
			}
			return tmp.substring(0, maxT);
		}
        
    }
}
