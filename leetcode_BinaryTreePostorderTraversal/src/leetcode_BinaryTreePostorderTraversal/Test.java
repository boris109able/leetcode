package leetcode_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l2 = new TreeNode(3);
		root.left = null;
		root.right = l1;
		l1.left = l2;
		l1.right = null;
		l2.left = null;
		l2.right = null;
		Solution sol = new Solution();
		List<Integer> a = sol.postorderTraversal(root);
		System.out.println(a+":"+a.size());	
	}
}


