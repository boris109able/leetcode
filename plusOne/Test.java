package plusOne;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] digits = new int[] {9,9,9,8,9};
		int[] result = sol.plusOne(digits);
		for(int i=0; i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}

}
