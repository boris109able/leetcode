package leetcode_LongestPanlindromicSubstring;

public class Test {
	public static void main(String[] args) {
		String s = "abb";
		Solution sol = new Solution();
		System.out.println(sol.postProcess(s));
		/*int[] P = sol.longestPalindrome(s);
		for(int i=0; i<P.length; i++) {
			System.out.print(P[i]+" ");
		}*/
		System.out.println(sol.longestPalindrome(s));
	}

}
