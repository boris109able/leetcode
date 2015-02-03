package searchForARange;

public class Test {
	public static void main(String[] args) {
		int[] A = new int[] {5, 7, 7, 8, 8, 10};
		Solution sol = new Solution();
		int[] pos = sol.searchRange(A, 8);
		System.out.println("["+pos[0]+", "+pos[1]+"]");
	}

}
