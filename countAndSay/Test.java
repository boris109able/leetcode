package countAndSay;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.rl("1"));
		
		for(int i=1; i<6; i++) {
			System.out.println(sol.countAndSay(i));
		}
		System.out.println(sol.countAndSay(2));
	}
}
