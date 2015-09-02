package nextPermutation;

public class Test {
	public static void main(String[] args) {
		int[] num = new int[] {5,1,1};
		Solution sol = new Solution();
		sol.nextPermutation(num);
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
	}
}
