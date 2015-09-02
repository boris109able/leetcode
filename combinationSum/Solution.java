package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public void print(int[] A) {
		for(int i=0;i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	public int[] remove(int[] candidates) {
		if(candidates.length<=1) {
			return candidates;
		}
		int r=1, l=1;
		while(r<candidates.length) {
			while(candidates[r]==candidates[r-1]) {
				r++;
				if(r>=candidates.length) {
					break;
				}
			}
			if(r>=candidates.length) {
				break;
			}
			candidates[l] = candidates[r];
			l++;r++;
		}
		int[] A = new int[l];
		for(int i=0; i<l; i++) {
			A[i] = candidates[i];
		}
		return A;
	}
	public void deepcopy(List<Integer> ttmp, List<Integer> tmp) {
		for(int i=0; i<tmp.size(); i++) {
			ttmp.add(tmp.get(i));
		}
	}
	public void find(int[] candidates, int target, int idx, List<Integer> tmp, List<List<Integer>> r) {
		System.out.println(tmp+" "+target);
		if(target==0) {
			r.add(tmp);
			return;
		}
		if(target<candidates[idx]) {
			return;
		}
		for(int i=idx; i<candidates.length; i++) {
			List<Integer> ttmp = new ArrayList<Integer>();
			if(target>=candidates[i]) {
				deepcopy(ttmp, tmp);
				ttmp.add(candidates[i]);
				find(candidates, target-candidates[i], i, ttmp, r);
			}
		}
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		int[] a;
		if(candidates.length==0) {
			return r;
		}
		else if(candidates.length==1) {
			a = candidates;
		}
		else {
			Arrays.sort(candidates);
			a = remove(candidates);
		}
		print(a);
		List<Integer> tmp = new ArrayList<Integer>();
		find(a, target, 0, tmp, r);
        return r;
    }

}
