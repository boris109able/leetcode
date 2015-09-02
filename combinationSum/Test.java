package combinationSum;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] candidates = new  int[]{8,7,4,3};
		System.out.println(sol.combinationSum(candidates, 11));
		/*
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		tmp.add(1); tmp.add(2); tmp.add(3); a.add(tmp);
		System.out.println(a);System.out.println(tmp);
		tmp.clear();
		System.out.println(a);System.out.println(tmp);
		*/
	}
}
