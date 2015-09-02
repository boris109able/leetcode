package anagrams;

import java.util.*;

public class Solution {
	public List<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if(strs==null || strs.length==0) {
			return result;
		}
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		for(int i=0; i<strs.length; i++) {
			char[] charstr = strs[i].toCharArray();
			Arrays.sort(charstr);
			String tstr = new String(charstr);
			if(map.containsKey(tstr)) {
				map.get(tstr).add(i);
			}
			else {
				ArrayList<Integer> vlist = new ArrayList<Integer>();
				vlist.add(i);
				map.put(tstr, vlist);
			}
		}
		
		for(ArrayList<Integer> vlist: map.values()) {
			if(vlist.size()>1) {
				for(int i: vlist) {
					result.add(strs[i]);
				}
			}
		}
		return result;
    }
}
