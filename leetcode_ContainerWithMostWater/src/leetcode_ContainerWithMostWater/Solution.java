package leetcode_ContainerWithMostWater;

public class Solution {
	public int maxArea(int[] height) {
        if(height==null || height.length<=1) {
        	return 0;
        }
        else {
        	int l=0, r=height.length-1, maxA = 0, tmpA;
        	maxA = (r-l)*Math.min(height[l], height[r]);
        	while(l<r) {
        		if(height[l]<height[r]) {
        			l++;
        		}
        		else {
        			r--;
        		}
        		tmpA = (r-l)*Math.min(height[l], height[r]);
        		if(tmpA > maxA) {
        			maxA = tmpA;
        		}
        	}
        	return maxA;
        }
    }
}
