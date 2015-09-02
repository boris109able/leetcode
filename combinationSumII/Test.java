package combinationSumII;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] candidates = new  int[]{10,1,2,7,6,1,5};
		System.out.println(sol.combinationSum2(candidates, 8));
		candidates = new  int[]{1};
		System.out.println(sol.combinationSum2(candidates, 2));
	}
}
