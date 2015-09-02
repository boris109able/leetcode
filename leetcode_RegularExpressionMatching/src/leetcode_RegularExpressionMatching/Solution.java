package leetcode_RegularExpressionMatching;

public class Solution {
	boolean isMatchMethod(String s, String p, int s1, int s2) {
		int len1 = s.length(), len2 = p.length();
		if(s1==len1 && s2==len2) {
			return true;
		}
		else if(s1!=len1 && s2==len2) {
			return false;
		}
		else if(s1==len1 && s2!=len2) {
			if((len2-s2)%2==0) {
				char top1, top2;
				while(s2!=len2) {
					top1 = p.charAt(s2);
					top2 = p.charAt(s2+1);
					if(top1 != '*' && top2 == '*') {
						s2 += 2;
					}
					else {
						return false;
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
		else {
			char top1, top2;
			top1 = p.charAt(s2);
			if(len2-s2>1) {				
				top2 = p.charAt(s2+1);
				if(top2 == '*') {
					int tmpLen = 0;
					if(top1 == '.') {
						tmpLen = len1 - s1;
					}
					else {
						while(s.charAt(s1+tmpLen)==top1) {
							tmpLen++;
							if(s1+tmpLen>s.length()-1) {
								break;
							}
						}
					}
					for(int i=0; i<=tmpLen; i++) {
						if(isMatchMethod(s, p, s1+i, s2+2))
						{
							return true;
						}
					}
					return false;
				}
				else {
					if(s.charAt(s1) == top1 || top1 == '.') {
						return isMatchMethod(s, p, s1+1, s2+1);
					}
					else {
						return false;
					}
				}
			}
			else {
				if(s.charAt(s1) == top1 || top1 == '.') {
					return isMatchMethod(s, p, s1+1, s2+1);
				}
				else {
					return false;
				}	
			}
		}				
}
	public boolean isMatch(String s, String p) {
		if(s==null && p==null) {
			return true;
		}
		else if((s!=null && p==null) || (s==null && p!=null)) {
			return false;
		}
		else {
			if(s.length()==0 && p.length()==0) {
				return true;
			}
			else {
				return isMatchMethod(s, p, 0, 0);
			}			
		}			    
    }
}
