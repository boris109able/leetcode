package leetcode_LongestCommonPrefix;

public class Test {
	public static void main(String[] args) {
		String[] strs = new String[2];
		strs[0] = new String("aa");
		strs[1] = new String("a");
		//strs[2] = new String("aaaaaaa");
		Solution sol = new Solution();
		System.out.println(sol.longestCommonPrefix(strs));
	}

}
