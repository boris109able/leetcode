package multiplyStrings;

public class Solution {
	public String add(String num1, String num2) {
		String re = new String();
		String tmp;
		int jinwei = 0, jieguo = 0, ttmp;
		if(num1.length()<num2.length()) {
			tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		int len1 = num1.length(), len2 = num2.length();
		for(int i=0; i<len2; i++) {
			ttmp = Integer.parseInt(Character.toString(num1.charAt(len1-1-i)))+Integer.parseInt(Character.toString(num2.charAt(len2-1-i)))+jinwei;
			jieguo = ttmp%10;
			jinwei = ttmp/10;
			re += jieguo;
		}
		for(int i=len2; i<len1; i++) {
			ttmp = Integer.parseInt(Character.toString(num1.charAt(len1-1-i)))+jinwei;
			jieguo = ttmp%10;
			jinwei = ttmp/10;
			re += jieguo;
		}
		if(jinwei>0) {
			re += jinwei;
		}
		String st = new String();
		for(int i=0; i<re.length(); i++) {
			st += re.charAt(re.length()-1-i);
		}
		return st;
	}
	String shift(String num, int l) {
		String re = new String();
		re += num;
		for(int i=0; i<l; i++) {
			re += "0";
		}		
		return re;
	}
	String sinMul(String num1, int num2) {
		String re = new String();
		int jinwei = 0, jieguo = 0, tmp, len = num1.length();
		for(int i=0; i< len; i++) {
			tmp = Integer.parseInt(Character.toString(num1.charAt(len-1-i)))*num2+jinwei;
			jieguo = tmp%10;
			jinwei = tmp/10;
			re += jieguo;
		}
		if(jinwei>0) {
			re += jinwei;
		}
		String st = new String();
		for(int i=0; i<re.length(); i++) {
			st += re.charAt(re.length()-1-i);
		}
		return st;
	}
	public String multiply(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
		String int1 = new String(), int2 = new String();
		int pos1 = 0, pos2 = 0;
		for(int i=0; i<len1; i++) {
			if(num1.charAt(i)=='.') {
				pos1 = len1 - (i+1);
			}
			else {
				int1 += num1.charAt(i);
			}
		}
		for(int i=0; i<len2; i++) {
			if(num2.charAt(i)=='.') {
				pos2 = len2 - (i+1);
			}
			else {
				int2 += num2.charAt(i);
			}
		}
		int dot = pos1+pos2;
		String ttmp;
		if(int1.length()<int2.length()) {
			ttmp = int1;
			int1 = int2;
			int2 = ttmp;
		}
		/*
		System.out.println(int1);
		System.out.println(int2);
		System.out.println(dot);
		*/
		String result = new String();
		String[] sin = new String[10];
		sin[0] = "0";
		for(int i=1; i<10; i++) {
			sin[i] = sinMul(int1, i);
			//System.out.println(sin[i]);
		}
		result = sin[Integer.parseInt(Character.toString(int2.charAt(int2.length()-1)))];
		for(int i=1; i<int2.length(); i++) {
			result = add(result, shift(sin[Integer.parseInt(Character.toString(int2.charAt(int2.length()-1-i)))],i));
		}
		String re2 = new String();
		re2 += result.substring(0, result.length()-dot);
		if(dot>0) {
			re2 += ".";
		}
		re2 += result.substring(result.length()-dot, result.length());
        return re2;
    }
}
