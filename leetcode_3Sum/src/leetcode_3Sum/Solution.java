package leetcode_3Sum;

import java.util.Arrays;
import java.util.*;

public class Solution {
	boolean search(int[] num, int i, int j, int target) {
		if(i>j) {
			return false;
		}
		int mid = (i+j)/2;
		if(num[mid] == target) {
			return true;
		}
		else if(num[mid] < target) {
			return search(num, mid+1, j, target);
		}
		else {
			return search(num, i, mid-1, target);
		}
		
	}
	boolean check(List<List<Integer>> list, ArrayList<Integer> tmp) {
		for(int i=0; i<list.size(); i++) {
			if(tmp.get(0)==list.get(i).get(0) && tmp.get(1)==list.get(i).get(1) && tmp.get(2)==list.get(i).get(2)) {
				return true;
			}
		}
		return false;
	}
	public List<List<Integer>> threeSum(int[] num) {
		if(num==null) {
			return null;
		}
		else if (num.length<3){
			//throw new RuntimeException("Array length is less than 3."); 
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			return result;
		}
		else {
			Arrays.sort(num);
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			int mid, r;
			for(int i=0; i<num.length-2; i++) {
				if(i==0 || num[i]>num[i-1])	{
					mid = i+1;
					r = num.length-1;
					while(mid<r) {
						if(num[mid]+num[r]+num[i]==0) {
							ArrayList<Integer> tmp = new ArrayList<Integer>();
							tmp.add(num[i]);tmp.add(num[mid]);tmp.add(num[r]);
							result.add(tmp);
							mid++;
							r--;
							while(mid<num.length && num[mid]==num[mid-1]) {
								mid++;
							}
							while(r>=0 && num[r]==num[r+1]) {
								r--;
							}
						}
						else if(num[mid]+num[r]+num[i]>0) {
							r--;
						}
						else{
							mid++;
						}
					}
				}
			}
			return result;					
		}      
    }
}
