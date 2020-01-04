package com.grt.recursive;

import java.util.ArrayList;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

public class Subsets {
	public static void main(String[] args) {
		Subsets obj = new Subsets();
		int[] s = {1, 2, 3};
		ArrayList<ArrayList<Integer>> result = obj.subsets(s);
		System.out.println("result:"+JSON.toJSONString(result));
	}
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	Stack<Integer> stack = new Stack();
	
	public ArrayList<ArrayList<Integer>> subsets(int[] s) {
		for(int len=0; len<=s.length; len++){
			dfs(len, 0, s);
		}
		return result;
	}
	void dfs(int len, int start, int[] s){
		if(len==0){
			result.add(new ArrayList(stack));
		}
		for(int i=start; i<s.length; i++){
			int num = s[i];
			stack.push(num);
			dfs(len-1, i+1, s);
			stack.pop();
		}
	}
}

