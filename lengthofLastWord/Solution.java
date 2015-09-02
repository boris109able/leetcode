package lengthofLastWord;

public class Solution {
	public int lengthOfLastWord(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		int i;
		int pos=s.length()-1;
		while(pos>=0 && s.charAt(pos)==' ') {
			pos--;
		}
		if(pos<0) {
			return 0;
		}
		System.out.println(pos);
		for(i=pos;i>=0;i--) {
			if(s.charAt(i)==' ') {
				break;
			}
		}
		return pos-i;
    }
}