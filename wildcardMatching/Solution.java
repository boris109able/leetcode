package wildcardMatching;

public class Solution {
	boolean strMatch(String s, String p) {
		if(s.length()!=p.length()) {
			return false;
		}
		for(int i=0; i<s.length(); i++) {
			if(p.charAt(i)!='?' && s.charAt(i)!=p.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	/*
	boolean subMatch(String s, int ps, String p, int pp) {
		if(ps==s.length() && pp==p.length()) {
			return true;
		}
		if(ps<s.length() && pp==p.length()) {
			return false;
		}
		if(ps==s.length() && pp<p.length()) {
			return false;
		}
		if(p.charAt(pp)=='*') {
			for(int i=0; i<=s.length()-ps; i++) {
				if(subMatch(s, ps+i, p, pp+1)) {
					return true;
				}
			}
			return false;
		}
		else {
			if(p.charAt(pp)=='?' || s.charAt(ps)==p.charAt(pp)) {
				return subMatch(s, ps+1, p, pp+1);
			}
			else {
				return false;
			}
		}
	}
	public boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0) {
        	return true;
        }
        if(s.length()>0 && p.length()==0) {
        	return false;
        }
        if(s.length()==0 && p.length()>0) {
        	return false;
        }
        String tp = new String();
        int l = 0, len=0, count=0;
        ArrayList<Integer> star = new ArrayList<Integer>();
        while(l<p.length()) {
        	if(p.charAt(l)=='*') {
        		len = 1;
        		while(l+len<p.length() && p.charAt(l)==p.charAt(l+len)) {
        			len++;
        		}
        		tp += '*';
        		l += len;
        		star.add(count);
        	}
        	else {
        		tp += p.charAt(l);
        		l += 1;
        		
        	}
        	count++;
        }
        System.out.println(s);
        System.out.println(tp);
        System.out.println(star);
        return subMatch(s, 0, tp, 0);
    }
    */
	public boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0) {
        	return true;
        }
        if(s.length()>0 && p.length()==0) {
        	return false;
        }
        if(s.length()==0 && p.length()>0) {
        	for(int i=0; i<p.length(); i++) {
        		if(p.charAt(i)!='*') {
        			return false;
        		}
        	}
        	return true;
        }
        int is=0, ip=0;
        int ss=-1, sp=-1;
        while(is<s.length()) {
        	if(ip<p.length() && (p.charAt(ip)=='?'|| s.charAt(is)==p.charAt(ip))) {
        		is++;ip++;continue;
        	}
        	if(ip<p.length() && p.charAt(ip)=='*') {
        		ss=is;sp=ip++;continue;
        	}
        	if(sp>=0) {
        		is=++ss;ip=sp+1;;continue;
        	}
        	return false;
        }
        if(ip<p.length()) {
        	for(int i=ip; i<p.length(); i++) {
        		if(p.charAt(i)!='*') {
        			return false;
        		}
        	}
        }
        return true;
    }
}