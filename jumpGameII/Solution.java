package jumpGameII;

public class Solution {
	public int jump(int[] A) {
		int pos=0, count=0;
		int max, maxId;
		while(pos<A.length-1) {			
			if(pos+A[pos]>=A.length-1) {
				count++;pos=A.length-1;
			}
			else {
				max=0;maxId=pos;
				for(int i=1;i<=A[pos];i++){
					if(A[pos+i]+i>max){
						max=A[pos+i]+i;
						maxId=pos+i;
					}
				}
				pos=maxId;
				count++;
			}
			System.out.println(pos);
		}
        return count;
    }
}
