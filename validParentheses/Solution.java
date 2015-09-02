package validParentheses;

import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		Stack<Character> p = new Stack<Character>();
		char tmp, newChar;
		for(int i=0; i<s.length(); i++) {
			newChar = s.charAt(i);
			if(p.isEmpty()) {
				p.push(newChar);
			}
			else {
				tmp = p.peek();
				if((tmp == '(' && newChar==')')||(tmp == '[' && newChar==']')||(tmp == '{' && newChar=='}')) {
					p.pop();
				}
				else {
					p.push(newChar);
				}
			}
		}
		//System.out.println(p);
		//System.out.println(p.size());
		return p.isEmpty();
    }
}
