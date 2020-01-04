package com.grt.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
/*
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
   /     /
  8     9
*/
public class TestTree {
	public static void main(String[] args) {
		TestTree obj = new TestTree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n6.left = n9;
		
		Map map = obj.treeToMap(n1);
		System.out.println("map:"+JSON.toJSONString(map));
		//obj.bfs(n1);
		obj.zigzag(n1);
	}
	
	LinkedList<TreeNode> queue = new LinkedList();
	LinkedList<TreeNode> queue2 = new LinkedList();
	List<List<TreeNode>> zzList = new ArrayList();
	
	public void zigzag(TreeNode root){
		boolean leftToRight = false;
		queue.add(root);
		TreeNode node = null;
		while(true){
			while(!queue.isEmpty()){
				node = queue.poll();
				System.out.println(node.val);
				if(node.left!=null){
					queue2.add(node.left); 
				}
				if(node.right!=null){
					queue2.add(node.right);
				}
			}
			LinkedList tmp = queue;
			queue = queue2;
			queue2 = tmp;
			if(!leftToRight){
				Collections.reverse(queue);
			}
			leftToRight = !leftToRight;
			System.out.println("leftToRight:"+leftToRight+" queue:"+JSON.toJSONString(queue));
			if(queue.isEmpty()){
				break;
			}
		}
	}
	
	public void bfs(TreeNode root){
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if(node.left!=null){
				queue.add(node.left); 
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
	}
	
	public HashMap<Integer, List<TreeNode>> treeToMap(TreeNode root){
		HashMap<Integer, List<TreeNode>> map = new HashMap();
		int level = 0;
		List<TreeNode> list = new ArrayList();
		list.add(root);
		map.put(level, list);
		
		while(list.size()>0){ //one level per loop, starts from level 0
			list = new ArrayList();
			for(int i=0; i<map.get(level).size(); i++){
				TreeNode node = map.get(level).get(i);
				if(node.left!=null){
					list.add(node.left);
				}
				if(node.right!=null){
					list.add(node.right);
				}
			}
			map.put(++level, list);
		}
		return map;
	}

}
