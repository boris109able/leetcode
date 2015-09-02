package permutations;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	boolean next(int[] seq) {
		int i=seq.length-1;
		while(i>=1 && seq[i-1]>seq[i]){
			i--;
		}
		if(i==0) {
			Arrays.sort(seq);
			return false;
		}
		else {
			int min=seq[i], ind=i;
			for(int k=i;k<seq.length;k++){
				if(seq[k]>seq[i-1]&&seq[k]<min) {
					min=seq[k];
					ind=k;
				}
			}
			int tmp;
			tmp=seq[i-1];
			seq[i-1]=seq[ind];
			seq[ind]=tmp;
			Arrays.sort(seq,i,seq.length);
			return true;
		}				
	}
	List<Integer> convert(int[] num) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=0;i<num.length;i++){
			a.add(num[i]);
		}
		return a;
	}
	public List<List<Integer>> permute(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		System.out.println(convert(num));
		result.add(convert(num));
		while(next(num)){
			System.out.println(convert(num));
			result.add(convert(num));
		}		
		return result;	 
	}
}
