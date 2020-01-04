package com.grt.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

public class Combination3 {
	public static void main(String[] args){
		Combination3 obj = new Combination3();
		List<List<Integer>> result = obj.combinationSum3(3, 9);
		System.out.println("result:"+JSON.toJSONString(result));
	}
	
    public List<List<Integer>> combinationSum3(int k, int n) {
    	return combinationSum3(k, n, 1);
    }
    public List<List<Integer>> combinationSum3(int k, int n, int start) {
    	List<List<Integer>> result = new ArrayList();
    	if(k==0 && n!=0){
    		return result;
    	}
    	if(k==0 && n==0){
    		result.add(new ArrayList<Integer>());
    		return result;
    	}
    	
    	for(int i=start; i<=9; i++){
    		List<List<Integer>> subResult = combinationSum3(k-1, n-i, i+1);
    		for(List<Integer> list: subResult){
    			list.add(i);
    			result.add(list);
    		}
    	}    
    	return result;
    }
}
