package leetcode_LetterCombinationsofaPhoneNumber;

import java.util.*;

public class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if(digits.length()==0) {
			return list;
		}
		else {
			Hashtable<Character, String> map = new Hashtable<Character, String>();
			map.put('2',"abc"); map.put('3',"def"); map.put('4',"ghi");
			map.put('5',"jkl"); map.put('6',"mno"); map.put('7',"pqrs");
			map.put('8',"tuv"); map.put('9',"wxyz"); map.put('0'," ");
			String tmp = new String(); int size = 0, value, len = digits.length(), tmp1;
			//Stack<Character> stack = new Stack<Character>();
			Stack<Integer> state = new Stack<Integer>();
			char[] str = new char[len]; int capacity = 0;
			state.push(0); //stack.push(map.get(digits.charAt(0)).charAt(0));
			str[capacity] = map.get(digits.charAt(0)).charAt(0); capacity++;
			while(!state.empty()) {
				size = state.size();
				value = map.get(digits.charAt(size-1)).length();
				if(state.peek() < value) {
					while(state.size()<len) {
						state.push(0);
						str[capacity] = map.get(digits.charAt(state.size()-1)).charAt(0);
						capacity++;
					}
					tmp = new String(str);
					list.add(tmp);
				}
				else {
					while(state.peek()>= value) {
						state.pop();
						if(state.size()==0) {
							return list;
						}
						value = map.get(digits.charAt(size-1)).length();
					}
					tmp1 = state.peek()+1;
					state.pop(); state.push(tmp1);
				}
			}
			return list;
		}			 
    }
}
