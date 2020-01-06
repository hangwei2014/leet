package com.grt.tree;

import com.alibaba.fastjson.JSON;

public class TreeNode {
	public static void main(String[] args){
		TreeNode root = TreeNode.str2tree("5,4,9,2,#,8,10");
		System.out.println("root:"+JSON.toJSONString(root));
	}
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int n){
		val = n;
	}
	
	
	//5,4,9,2,#,8,10
	public static TreeNode str2tree(String str){
		String[] tokens = str.split(",");
		TreeNode[] nodes = new TreeNode[tokens.length];
		for(int i=0; i<tokens.length; i++){
			String token = tokens[i];
			TreeNode node = null;
			try{
				node = new TreeNode(Integer.parseInt(token));
			}catch(Exception e){}
			nodes[i] = node;			
		}
		
		for(int i=1; i<nodes.length; i++){
			TreeNode node = nodes[i];
			int parentIdx = (i-1)/2;
			if(i%2==1){
				nodes[parentIdx].left = node;
			}else{
				nodes[parentIdx].right = node;
			}
		}
		return nodes[0];
	}
	
	public static boolean isInteger(String s){
		try{
			Integer.parseInt(s);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
}
