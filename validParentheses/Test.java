package validParentheses;

public class Test {
	public static void main(String[] args) {
		String s1 = "()";
		String s2 = "()[]{}";
		String s3 = "(]";
		String s4 = "([)]";
		Solution sol = new Solution();
		System.out.println(sol.isValid(s1));
		System.out.println(sol.isValid(s2));
		System.out.println(sol.isValid(s3));
		System.out.println(sol.isValid(s4));
	}

}
