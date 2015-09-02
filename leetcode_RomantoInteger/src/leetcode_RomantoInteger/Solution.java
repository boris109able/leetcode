package leetcode_RomantoInteger;

public class Solution {
	public int romanToInt(String s) {
		int sum=0, i=0;
		while(i<s.length() && s.charAt(i)=='M' ) {
			i++;
		}
        sum += 1000*i;
        	if(i<s.length()-3) {
        		if(s.charAt(i)=='D' && s.charAt(i+1)=='C' && s.charAt(i+2)=='C' && s.charAt(i+3)=='C') {
        			sum += 800;
        			i += 4;
        		}
        	}
        	if(i<s.length()-2) {
        		if(s.charAt(i)=='C' && s.charAt(i+1)=='C' && s.charAt(i+2)=='C') {
        			sum += 300;
        			i += 3;
        		}
        		else if(s.charAt(i)=='D' && s.charAt(i+1)=='C' && s.charAt(i+2)=='C') {
        			sum += 700;
        			i += 3;
        		}
        	}
        	if(i<s.length()-1) {
        		if(s.charAt(i)=='C' && s.charAt(i+1)=='C') {
        			sum += 200;
        			i += 2;
        		}
        		else if(s.charAt(i)=='C' && s.charAt(i+1)=='D') {
        			sum += 400;
        			i += 2;
        		}
        		else if(s.charAt(i)=='D' && s.charAt(i+1)=='C') {
        			sum += 600;
        			i += 2;
        		}
        		else if(s.charAt(i)=='C' && s.charAt(i+1)=='M') {
        			sum += 900;
        			i += 2;
        		}
        	}
        	if(i<s.length()) {
        		if(s.charAt(i)=='C') {
        			sum += 100;
        			i++;
        		}
        		else if(s.charAt(i)=='D') {
        			sum += 500;
        			i++;
        		}
        	}  	
    
        	if(i<s.length()-3) {
        		if(s.charAt(i)=='L' && s.charAt(i+1)=='X' && s.charAt(i+2)=='X' && s.charAt(i+3)=='X') {
        			sum += 80;
        			i += 4;
        		}
        	}
        	if(i<s.length()-2) {
        		if(s.charAt(i)=='X' && s.charAt(i+1)=='X' && s.charAt(i+2)=='X') {
        			sum += 30;
        			i += 3;
        		}
        		else if(s.charAt(i)=='L' && s.charAt(i+1)=='X' && s.charAt(i+2)=='X') {
        			sum += 70;
        			i += 3;
        		}
        	}
        	if(i<s.length()-1) {
        		if(s.charAt(i)=='X' && s.charAt(i+1)=='X') {
        			sum += 20;
        			i += 2;
        		}
        		else if(s.charAt(i)=='X' && s.charAt(i+1)=='L') {
        			sum += 40;
        			i += 2;
        		}
        		else if(s.charAt(i)=='L' && s.charAt(i+1)=='X') {
        			sum += 60;
        			i += 2;
        		}
        		else if(s.charAt(i)=='X' && s.charAt(i+1)=='C') {
        			sum += 90;
        			i += 2;
        		}
        	}
        	if(i<s.length()) {
        		if(s.charAt(i)=='X') {
        			sum += 10;
        			i++;
        		}
        		else if(s.charAt(i)=='L') {
        			sum += 50;
        			i++;
        		}
        	}     	
        	if(i<s.length()-3) {
        		if(s.charAt(i)=='V' && s.charAt(i+1)=='I' && s.charAt(i+2)=='I' && s.charAt(i+3)=='I') {
        			sum += 8;
        			i += 4;
        		}
        	}
        	if(i<s.length()-2) {
        		if(s.charAt(i)=='I' && s.charAt(i+1)=='I' && s.charAt(i+2)=='I') {
        			sum += 3;
        			i += 3;
        		}
        		else if(s.charAt(i)=='V' && s.charAt(i+1)=='I' && s.charAt(i+2)=='I') {
        			sum += 7;
        			i += 3;
        		}
        	}
        	if(i<s.length()-1) {
        		if(s.charAt(i)=='I' && s.charAt(i+1)=='I') {
        			sum += 2;
        			i += 2;
        		}
        		else if(s.charAt(i)=='I' && s.charAt(i+1)=='V') {
        			sum += 4;
        			i += 2;
        		}
        		else if(s.charAt(i)=='V' && s.charAt(i+1)=='I') {
        			sum += 6;
        			i += 2;
        		}
        		else if(s.charAt(i)=='I' && s.charAt(i+1)=='X') {
        			sum += 9;
        			i += 2;
        		}
        	}
        	if(i<s.length()) {
        		if(s.charAt(i)=='I') {
        			sum += 1;
        			i++;
        		}
        		else if(s.charAt(i)=='V') {
        			sum += 5;
        			i++;
        		}
        	}  	
        return sum;
    }
}
