package maximumSubarray;

public class Solution {
	public int maxSubArray(int[] nums) {
        //s[n] maximum sum of subarray from 1 to n
		//e[n] maximum sum of subarray from 1 to n ending at n (including nums[n])
		if(nums==null || nums.length==0) {
			return 0;
		}
		int sn=0, en, sn_prev, en_prev;
		sn = nums[0];
		en = nums[0];
		sn_prev = nums[0];
		en_prev = nums[0];
		for(int i=1;i<nums.length;i++) {
			en = Math.max(nums[i], nums[i]+en_prev);
			sn = Math.max(sn_prev, en);
			en_prev = en;
			sn_prev = sn;
		}
		return sn;
    }
}
