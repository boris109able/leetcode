package jumpGame;

public class Solution {
	public boolean canJump(int[] nums) {
        int pos = 0;
        boolean flag = true;
        if(nums==null || nums.length==0) {
        	return flag;
        }
        int n = nums.length;
        int maxJ=0, max=0;
        while(pos<n-1) {
        	if(nums[pos]==0) {
        		flag = false;
        		break;
        	}
        	max = 0;
        	if(pos+nums[pos]>=n-1) {
        		break;
        	}
        	for(int i=1; i<=nums[pos]; i++) {
        		if(i+nums[pos+i]>max) {
        			max = i+nums[pos+i];
        			maxJ = i;
        		}
        	}
        	pos += maxJ;
        	System.out.println(pos+" "+max);
        }
        return flag;
    }
}