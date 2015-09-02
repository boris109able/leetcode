package multiplyStrings;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String num1 = "1.23434546";
		String num2 = "1292949394";
		System.out.println(sol.multiply(num1, num2));
		System.out.println(sol.multiply("0", "0"));
		/*
		System.out.println(sol.add("123", "4567"));
		System.out.println(sol.sinMul("223", 6));
		System.out.println(sol.shift("223", 5));
		System.out.println(num2.substring(0, 1));
		*/
		//System.out.println(Integer.parseInt(Character.toString(num2.charAt(1))));
	}
}
