package leetcode_BinaryTreeMaximumPathSum;

import java.util.Arrays;

public class Solution {
	public int[] MN(TreeNode root)
	{
		int[] Newmn = new int[2];
		int[] OldmnL = new int[2];
		int[] OldmnR = new int[2];
		int val = root.val;
		if(root.left==null && root.right==null)
		{
			Newmn[0] = val;//m
			Newmn[1] = val;//n
		}
		else if(root.left!=null && root.right==null)
		{
			OldmnL = MN(root.left);
			int[] m = new int[3];
			m[0] = val;m[1]=OldmnL[0];m[2]=OldmnL[1]+val;Arrays.sort(m);
			Newmn[0] = m[2];
			Newmn[1] = (val>OldmnL[1]+val)? val:OldmnL[1]+val;
		}
		else if(root.left==null && root.right!=null)
		{
			OldmnR = MN(root.right);
			int[] m = new int[3];
			m[0] = val;m[1]=OldmnR[0];m[2]=OldmnR[1]+val;Arrays.sort(m);
			Newmn[0] = m[2];
			Newmn[1] = (val>OldmnR[1]+val)? val:OldmnR[1]+val;
		}
		else
		{
			OldmnL = MN(root.left);
			OldmnR = MN(root.right);
			int[] m = new int[6];
			m[0] = val;m[1]=OldmnL[0];m[2]=OldmnR[0];m[3]=OldmnL[1]+val;m[4]=OldmnR[1]+val;m[5]=OldmnL[1]+OldmnR[1]+val;Arrays.sort(m);
			Newmn[0] = m[5];
			int[] n = new int[3];
			n[0] = val;n[1]=OldmnL[1]+val;n[2]=OldmnR[1]+val;Arrays.sort(n);
			Newmn[1] = n[2];
		}	 
		return Newmn;
	}
	public int maxPathSum(TreeNode root) {
		if(root==null)
		{
			return 0;
		}
		int[] result = MN(root);
		return result[0];
    }
}
