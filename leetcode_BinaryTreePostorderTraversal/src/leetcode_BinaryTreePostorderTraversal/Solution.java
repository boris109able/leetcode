package leetcode_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root)
	 {
		 ArrayList<Integer> num = new ArrayList<Integer>(0);
		 Stack<TreeNode> path = new Stack<TreeNode>();
		 Stack<Integer> state = new Stack<Integer>();
		 if(root == null)
		 {
			 return num;
		 }
		 TreeNode CurrentNode = root;
		 path.push(CurrentNode);//add CurrentNode into path
		 state.push(0);//means visit its left subtree
		 
		 while(!path.empty())
		 {
			 while(CurrentNode.left!=null)
			 {
				 CurrentNode = CurrentNode.left;
				 path.push(CurrentNode);
				 state.push(0);
			 }
			 //the cases below means CurrentNode.left==null
			 if(CurrentNode.right==null)//CurrentNode is a leaf node
			 {
				 //num.add(CurrentNode.val);
				 //and on the top of path is the node of this leaf node
				 while(state.peek()==1 || path.peek().right==null)//finish visiting right subtree of some parent node or that parent node has no right subtree at all
				 {
					CurrentNode = path.pop();
					num.add(CurrentNode.val);
					state.pop();
					if(path.empty())
					{
						return num;
					}
				 }
				 state.pop(); state.push(1); //start visiting right subtree
				 CurrentNode = path.peek().right;//set current node to the root of right subtree
				 path.push(CurrentNode);
				 //num.add(CurrentNode.val);//visit the node itself
				 state.push(0);//visit left subtree of the node
			 }
			 else
			 {
				 state.pop();state.push(1);//change sign of parent right subtree
				 
				 CurrentNode = CurrentNode.right;//visit right subtree
				 path.push(CurrentNode);
				 //num.add(CurrentNode.val);
				 state.push(0);
			 }
		 }
	     return num;
	 }

}
