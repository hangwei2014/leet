package com.grt.tree;

public class ClosestBinaryTreeValue {
	public static void main(String[] args){
		ClosestBinaryTreeValue obj = new ClosestBinaryTreeValue();
		TreeNode root = TreeNode.str2tree("5,4,9,2,#,8,10");
		int result = obj.closestValue(root, 0.12);
		System.out.println("result:"+result);
	}
	
	public int closestValue(TreeNode root, double target) {
		double minDiff = Double.MAX_VALUE;
		int val = root.val;
		while(root!=null){
			if(Math.abs(root.val - target)<minDiff){
				minDiff = Math.abs(root.val - target);
				val = root.val;
			}
			if(target==root.val){
				return root.val;
			}else if(target>root.val){
				root = root.right;			
			}else{
				root = root.left;
			}
		}
		return val;
	}
}
