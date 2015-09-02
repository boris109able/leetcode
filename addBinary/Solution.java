package addBinary;

public class Solution {
    public String addBinary(String a, String b) {
        String tmp;
        if(b.length()>a.length()) {
        	tmp = a;
        	a = b;
        	b = tmp;
        }
        int an=a.length(), bn=b.length();
        int av, bv, jinwei=0, tmpv;
        String result = new String();
        for(int i=0; i<bn;i++) {
        	av = (int)a.charAt(an-1-i)-48;
        	bv = (int)b.charAt(bn-1-i)-48;
        	tmpv = av+bv+jinwei;
        	jinwei = tmpv/2;
        	result += tmpv%2;   
        	//System.out.println("jinwei:"+jinwei);
        }
        //System.out.println(result);
        for(int i=an-bn-1;i>=0;i--) {
        	av = (int)a.charAt(i)-48;
        	tmpv = av+jinwei;
        	jinwei = tmpv/2;
        	result += tmpv%2;
        }
        //System.out.println(result);
        if(jinwei==1) {
        	result += jinwei;
        }
        //System.out.println(result);
        int l=0, r=result.length()-1;
        char tmpc;
        char[] re = result.toCharArray();
        while(l<r) {
        	tmpc = re[l];
        	re[l] = re[r];
        	re[r] = tmpc;
        	l++;
        	r--;
        }
        return new String(re);
    }
}