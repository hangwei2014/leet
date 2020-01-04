package com.grt.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

public class Combination2 {
	public static void main(String[] args){
		Combination2 obj = new Combination2();
		int[] candidates = {2,5,2,1,2};
		int target = 5;
		
		List<List<Integer>> result = obj.combinationSum2(candidates, target);
		System.out.println("result:"+JSON.toJSONString(result));
	}
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
		System.out.println("candidates:"+JSON.toJSONString(candidates));
    	return combinationSum2(candidates, target, 0);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target, int startIdx) {
    	List<List<Integer>> result = new ArrayList();
    	if(candidates.length==0 || target<0 || startIdx>candidates.length){
    		return result;
    	}
    	if(target==0){
    		List<Integer> list = new ArrayList<Integer>();
    		result.add(list);
    		return result;
    	}
        
    	for(int i=startIdx; i<candidates.length; i++){
        	if(i>startIdx && candidates[i]==candidates[i-1]){
        		continue;
        	}
    		List<List<Integer>> subResult = combinationSum2(candidates, target-candidates[i], i+1);
    		for(List<Integer> list: subResult){
    			list.add(candidates[i]);
    		}
    		result.addAll(subResult);
    	}
    	
    	return result;
    }

}
