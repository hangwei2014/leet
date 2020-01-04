package com.grt.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

public class Combination1 {
	public static void main(String[] args){
		Combination1 obj = new Combination1();
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> result = obj.combinationSum(candidates, target);
		System.out.println("result:"+JSON.toJSONString(result));
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	return combinationSum(candidates, target, 0);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target, int startIdx) {
    	List<List<Integer>> result = new ArrayList();
    	if(candidates.length==0 || target<0){
    		return result;
    	}
    	if(target==0){
    		List<Integer> list = new ArrayList<Integer>();
    		result.add(list);
    		return result;
    	}
    	
        
    	for(int i=startIdx; i<candidates.length; i++){
    		List<List<Integer>> subResult = combinationSum(candidates, target-candidates[i], i);
    		for(List<Integer> list: subResult){
    			list.add(candidates[i]);
    		}
    		result.addAll(subResult);
    	}
    	
    	return result;
    }

}
