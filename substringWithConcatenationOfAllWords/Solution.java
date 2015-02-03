package substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class Solution {
	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> lists = new ArrayList<Integer>();
        int wordLen = L[0].length(), wordNum = L.length;
        Hashtable<String, Integer> words = new Hashtable<String, Integer>();
        Hashtable<String, Integer> current = new Hashtable<String, Integer>();
        for(int i=0; i<wordNum; i++) {
        	if(words.containsKey(L[i])) {
        		words.put(L[i], words.get(L[i])+1);
        	}
        	else {
        		words.put(L[i], 1);
        	}
        }
        for(int i=0; i<wordNum; i++) {
        	System.out.println(L[i]+" : "+words.get(L[i]));
        } 
        String c, tmp;
        int j;
        for(int i=0; i<=S.length()-wordLen*wordNum; i++) {
        	current.clear();
        	System.out.println("adfsad");
        	for(j=0; j<wordNum; j++) {
        		c = S.substring(i+j*wordLen, i+(j+1)*wordLen);
        		System.out.print(c+" ");
        		if(!words.containsKey(c)) {
        			break;
        		}
        		if(current.containsKey(c)) {
        			current.put(c, current.get(c)+1);
        		}
        		else {
        			current.put(c, 1);
        		}
        	}
        	//System.out.println();
        	if(j!=wordNum) {
        		continue;
        	}
        	Enumeration<String> str = words.keys();
        	while(str.hasMoreElements()) {
        		tmp = str.nextElement();
        		if(words.get(tmp)!=current.get(tmp)) {
        			break;
        		}
        	}
        	if(!str.hasMoreElements()) {
        		lists.add(i);
        	}
        }
        return lists;
    }
}
