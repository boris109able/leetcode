package leetcode_3SumClosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num==null) {
        	return target;
        }
        if(num.length<3) {
        	return target;
        }
        else {
        	Arrays.sort(num);
        	int mid, r, diff=num[0]+num[1]+num[2]-target;
        	for(int i=0; i<num.length-2; i++) {
        		if(i==0 || num[i]>num[i-1]) {
        			mid = i+1;
        			r = num.length-1;
        			while(mid<r) {
        				if(Math.abs(num[mid]+num[r]+num[i]-target)<Math.abs(diff)) {
        					diff = num[mid]+num[r]+num[i]-target;
        				}
        				if(num[i]+num[mid]+num[r]==target) {
        					return target;
						}
						else if(num[i]+num[mid]+num[r]>target) {
							r--;
						}
						else{
							mid++;
						}
        			}
        		}
        	}
        	return diff+target;
        }
    }
}
