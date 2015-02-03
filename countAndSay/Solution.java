package countAndSay;

public class Solution {
	String rl(String a) {
		String b = new String();
		int count, i = 1;
		while(i<a.length()) {
			count = 1;
			while(i<a.length() && a.charAt(i)==a.charAt(i-1)) {
				count++; i++;
			}	
			b += Integer.toString(count);
			b += a.charAt(i-1);
			i++;
		}	
		if(i==a.length()) {
			b += Integer.toString(1);
			b += a.charAt(a.length()-1);
		}
		return b;
	}
	public String countAndSay(int n) {
        if(n==1) {
        	return "1";
        }
        String a = "1", b;
        for(int i=2; i<=n; i++) {
        	b = rl(a);
        	a = b;
        }
        return a;
    }
}
