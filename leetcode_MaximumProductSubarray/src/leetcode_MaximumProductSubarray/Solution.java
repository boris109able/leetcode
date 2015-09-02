package leetcode_MaximumProductSubarray;

public class Solution {
    public int findMax(int a, int b, int c)
    {
        int tmp = (a > b) ? a : b;
        return (tmp > c)? tmp: c;
    }
    public int findMin(int a, int b, int c)
    {
        int tmp = (a < b) ? a : b;
        return (tmp < c)? tmp: c;
    }
    public int findMaxInArray(int[] E)
    {
        int tmp=E[0];
        for(int i=0;i<E.length;i++)
        {
            if(tmp<E[i])
            {
                tmp = E[i];
            }
        }
        return tmp;
    }
    public int maxProduct(int[] A) {
        int n = A.length;
        if(n==1)
        {
            return A[0];
        }
        else
        {
            int[] E = new int[n];
            int[] G = new int[n];
            E[0] = A[0];
            G[0] = A[0];
            int tmp1, tmp2, tmp3;
            for(int t=1;t<n;t++)
            {
                tmp1 = E[t-1]*A[t];
                tmp2 = G[t-1]*A[t];
                tmp3 = A[t];
                E[t] = findMax(tmp1, tmp2, tmp3);
                G[t] = findMin(tmp1, tmp2, tmp3);
            }
            return findMaxInArray(E);
        }
    }
}