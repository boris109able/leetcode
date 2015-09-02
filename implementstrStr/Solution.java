package implementstrStr;

public class Solution {
	public int strStr(String haystack, String needle) {
		int lenh = haystack.length(), lenn=needle.length();
        if(lenn==0) {
        	return 0;
        }
        if(lenn>lenh) {
        	return -1;
        }
        for(int i=0; i<lenh; i++) {
        	if(haystack.charAt(i)==needle.charAt(0) && lenh-i>=lenn) {
        		if(match(haystack, needle, i)) {
        			return i;
        		}
        	}
        }
        return -1;
    }
	boolean match(String a, String b, int beg) {
		int lenb = b.length();
		for(int i=0; i<lenb; i++) {
			if(a.charAt(beg+i)!=b.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
