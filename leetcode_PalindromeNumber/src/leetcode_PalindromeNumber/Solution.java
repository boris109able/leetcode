package leetcode_PalindromeNumber;

public class Solution {
	int takeNDigit(int x, int n) {//n is base 0
		int pow = 1;
		for(int i=0; i<n; i++) {
			pow *= 10;
		}
		return (x/pow)%10;
	}
	public boolean isPalindrome(int x) {
		//System.out.println("Hello");
		if(x<0) {
			return false;
		}
		else if(x>=0 && x<=9) {
			return true;
		}
		else {
			long pow = 1;
			int n=1;
			while(true) {
				if(x/pow>0 && x/(10*pow) == 0) {
					break;
				}
				else {
					pow *= 10;
					n++;
				}
			}
			System.out.println("The value of n:"+n);
	        int mid = n/2, left, right;
	        for(int i=0; i<mid; i++) {
	        	left = takeNDigit(x, i);
	        	right = takeNDigit(x, n-1-i);
	        	if(left!=right) {
	        		return false;
	        	}
	        }
	        return true;
		}		
    }
}
