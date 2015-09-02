package validNumber;

import java.util.*;

public class Solution {
	public boolean isNonnegativeInteger(char[] s) {
		int len = s.length;
		boolean flag = true;
		for(int i=0;i<len;i++) {
			if(!(s[i]>='0' && s[i]<='9')) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	public boolean isInteger(char[] s) {
		if(s[0]=='+' || s[0]=='-') {
			if(1>=s.length) {
				return false;//flag true front, false later parts
			}
			else {
				char[] s1 = Arrays.copyOfRange(s, 1, s.length);
				return isNonnegativeInteger(s1);
			}			
		}
		return isNonnegativeInteger(s);
	}
	public boolean isNonnegativeFraction(char[] s) {
		int i;
		for(i=0;i<s.length;i++) {
			if(s[i]=='.') {
				break;
			}
		}
		if(i<s.length) {
			if(i+1>=s.length && i<=0) {
				return false;
			}
			else if(i+1>=s.length && i>0) {
				char[] s1 = Arrays.copyOfRange(s, 0, i);
				return isNonnegativeInteger(s1);
			}
			else if(i+1<s.length && i<=0) {
				char[] s2 = Arrays.copyOfRange(s, i+1, s.length);
				return isNonnegativeInteger(s2);
			}
			else {
				char[] s1 = Arrays.copyOfRange(s, 0, i);				
				char[] s2 = Arrays.copyOfRange(s, i+1, s.length);
				return (isNonnegativeInteger(s1)&&isNonnegativeInteger(s2));
			}	
		}
		return isInteger(s);
	}
	public boolean isFraction(char[] s) {
		if(s[0]=='+' || s[0]=='-') {
			if(1>=s.length) {
				return false;//flag true front, false later parts
			}
			else {
				char[] s1 = Arrays.copyOfRange(s, 1, s.length);
				return isNonnegativeFraction(s1);
			}			
		}
		return isNonnegativeFraction(s);
	}
	public boolean isExponential(char[] s) {
		int i;
		for(i=0;i<s.length;i++) {
			if(s[i]=='e') {
				break;
			}
		}
		if(i<s.length ) {
			if (i+1<s.length && i>0){
				char[] s1 = Arrays.copyOfRange(s, 0, i);
				char[] s2 = Arrays.copyOfRange(s, i+1, s.length);
				return (isFraction(s1) && isInteger(s2));
			}	
			else {
				return false;
			}
		}
		return isFraction(s);
	}
    public boolean isNumber(String s) {
        String ss = new String();
        int l=0, r=s.length()-1;
        while(s.charAt(l)==' ') {
        	l++;
        	if(l>s.length()-1) {
        		break;
        	}
        }
        if(l>s.length()-1) {
    		return false;
    	}
        while(s.charAt(r)==' ') {
        	r--;
        	if(r<0) {
        		break;
        	}
        }
        if(r<0) {
        	return false;
        }
        if(l>r) {
        	return false;
        }
        for(int i=l;i<=r;i++) {
        	ss += s.charAt(i);
        }
        char[] sss = ss.toCharArray();
        return isExponential(sss);
    }
}