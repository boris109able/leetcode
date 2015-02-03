package wildcardMatching;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.isMatch("aa","a"));
		System.out.println(sol.isMatch("aa","aa"));
		System.out.println(sol.isMatch("aaa","aa"));
		System.out.println(sol.isMatch("aa", "*"));
		System.out.println(sol.isMatch("aa", "a*"));
		System.out.println(sol.isMatch("ab", "?*"));
		System.out.println(sol.isMatch("aab", "c*a*b"));
		
		System.out.println(sol.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
		System.out.println(sol.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
	}
}
