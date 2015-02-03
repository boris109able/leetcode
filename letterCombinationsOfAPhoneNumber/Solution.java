package letterCombinationsOfAPhoneNumber;

import java.util.*;
public class Solution {
	public List<String> letterCombinations(String digits) {
		Hashtable<Character, String> limit = new Hashtable<Character, String>();
		limit.put('2', "abc");
		limit.put('3', "def");
		limit.put('4', "ghi");
		limit.put('5', "jkl");
		limit.put('6', "mno");
		limit.put('7', "pqrs");
		limit.put('8', "tuv");
		limit.put('9', "wxyz");
		limit.put('0', " ");
		List<String> result = new ArrayList<String>();
		if(digits.length()==0) {
			result.add("");
			return result;
		}
		int len = digits.length();
		int[] path = new int[len];
		int pos;
		boolean full = false;
		while(!full) {
			String tmp = new String();
			for(int i=0; i<len; i++) {
				tmp += limit.get(digits.charAt(i)).charAt(path[i]);
			}
			result.add(tmp);
			////////////////////////////////////////////////
			/*for(int i=0; i<len; i++) {
				System.out.print(path[i]+" "+limit.get(digits.charAt(i)).charAt(path[i])+" ");
			}
			System.out.println();*/
			////////////////////////////////////////////////
			path[len-1]++;
			if(path[len-1]>=limit.get(digits.charAt(len-1)).length()) {
				pos = len-1;
				while(pos>=1 && path[pos-1]+1>=limit.get(digits.charAt(pos-1)).length()) {
					pos--;
				}
				pos--;
				if(pos<0) {
					full = true;
					break;
				}
				path[pos]++;
				for(int i=pos+1; i<len; i++) {
					path[i] = 0;
				}
			}	
		}	
		return result;
    }
}
