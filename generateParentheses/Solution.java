package generateParentheses;

import java.util.*;

public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		char[] tmp = new char[2*n];
		getPa(result, tmp, 0, 0, n, 0);
		return result;
    }
	void getPa(List<String> result, char[] tmp, int l, int r, int n, int idx) {
		if(l==n && r==n) {
			result.add(new String(tmp));
		}
		else if(l<r) {
			return;
		}
		else {
			if(l<n) {
				tmp[idx] = '(';
				getPa(result, tmp, l+1, r, n, idx+1);
			}
			if(r<n) {
				tmp[idx] = ')';
				getPa(result, tmp, l, r+1, n, idx+1);
			}
		}
	}
}
