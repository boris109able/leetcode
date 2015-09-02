package leetcode_IntegertoRoman;

public class Solution {
	public String intToRoman(int num) {
		String result = new String();
		int p1 = num/1000;
		int p2 = num%1000;
		for(int i=0; i<p1; i++) {
			result += "M";
		}
		
		p1 = p2/100;
		p2 = p2%100;
		if(p1>=1 && p1<=3) { 
			for(int i=0; i<p1; i++) {
				result += "C";
			}
		}
		else if(p1==4) {
			result += "CD";
		}
		else if(p1==5) {
			result += "D";
		}
		else if(p1>=6 && p1<=8) {
			result += "D";
			for(int i=5; i<p1; i++) {
				result += "C";
			}
		}
		else if(p1==9) {
			result += "CM";
		}
		
		p1 = p2/10;
		p2 = p2%10;
		if(p1>=1 && p1<=3) { 
			for(int i=0; i<p1; i++) {
				result += "X";
			}
		}
		else if(p1==4) {
			result += "XL";
		}
		else if(p1==5) {
			result += "L";
		}
		else if(p1>=6 && p1<=8) {
			result += "L";
			for(int i=5; i<p1; i++) {
				result += "X";
			}
		}
		else if(p1==9) {
			result += "XC";
		}
		p1 = p2;
		if(p1>=1 && p1<=3) { 
			for(int i=0; i<p1; i++) {
				result += "I";
			}
		}
		else if(p1==4) {
			result += "IV";
		}
		else if(p1==5) {
			result += "V";
		}
		else if(p1>=6 && p1<=8) {
			result += "V";
			for(int i=5; i<p1; i++) {
				result += "I";
			}
		}
		else if(p1==9) {
			result += "IX";
		}
		return result;       
    }

}
