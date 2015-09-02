package fourSum;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] num = new int[]{-1,0,1,-2};
		/*Arrays.sort(num);
		for(int i=0; i<num.length; i++)
		{
			System.out.println(num[i]);
		}*/
		List<List<Integer>> result = sol.fourSum(num, 0);
		System.out.println(result);
	}
}
