package fourSum;

import java.util.*;
public class Solution {
	int incIndex(int[] num, int index) {
		while(num[index]==num[index+1]) {
			index++;
			if(index>=num.length-1) {
				break;
			}
		}
		index++;
		return index;
	}
	int decIndex(int[] num, int index) {
		while(num[index]==num[index-1]) {
			index--;
			if(index<=0) {
				break;
			}
		}
		index--;
		return index;
	}
	public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null) {
        	return result;
        }
        if(num.length<4) {
        	return result;
        }
        List<Integer> tmpResult = new ArrayList<Integer>();
        int r1, r2, l, r, tmpTarget;
        int i = 0, j = 0;
        while(i<num.length-3) {
        	r1 = num[i];
        	j = i + 1;
        	while(j<num.length-2) {
        		r2 = num[j];
        		tmpTarget = target-r1-r2;
        		l = j+1;
        		r = num.length-1;
        		while (l<r) {
        			//System.out.println(r1+" "+r2+" "+num[l]+" "+num[r]);
        			if(num[l]+num[r]<tmpTarget) {
        				l = incIndex(num, l);
        			}
        			else if (num[l]+num[r]>tmpTarget) {
        				r = decIndex(num, r);
        			}
        			else {
        				tmpResult.add(r1);
        				tmpResult.add(r2);
        				tmpResult.add(num[l]);
        				tmpResult.add(num[r]);
        				result.add(tmpResult);
        				tmpResult = new ArrayList<Integer>();
        				l = incIndex(num, l);
        				r = decIndex(num, r);
        			}     			
        		}
        		j = incIndex(num, j);
        	}
        	i = incIndex(num, i);
        }
        return result;       
    }
}
