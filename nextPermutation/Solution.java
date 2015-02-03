package nextPermutation;

public class Solution {
	void exchange(int[] num, int i, int j) {
		int tmp;
		tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	public void nextPermutation(int[] num) {
		int len = num.length, pos = num.length-1;
		if(num.length==1) {
			return;
		}
		while(pos-1>=0 && num[pos-1]>=num[pos]) {
			pos--;
		}
		if(pos==0) {
			int l = 0, r = len-1;
			while(l<r) {
				exchange(num, l, r);
				l++;r--;
			}
			return;
		}
		//pos--;
		int i = pos;
		while(i<len && num[i]>num[pos-1]) {
			i++;
		}
		exchange(num, pos-1, i-1);
		int l = pos, r = len-1;
		while(l<r) {
			exchange(num, l, r);
			l++; r--;
		}
		return;
    }
}
