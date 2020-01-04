package com.grt.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

public class Combination4 {
	public static void main(String[] args){
		Combination4 obj = new Combination4();
		int[] nums = {1,2,3};
		int result = obj.combinationSum4(nums, 4);
		System.out.println("result:"+result);
	}
	
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int result = 0;
        if(len==0 || target<0){
        	return 0;
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
    	for(int j=0; j<=target; j++){
    		for(int i=0; i<len; i++){
    			int num = nums[i];
        		if(j-num>=0){
        			dp[j] = dp[j-num]+dp[j];
        		}
        	}
        	System.out.println(j+":  : "+JSON.toJSONString(dp));
        }
        return dp[target];
    }


	
    public int combinationSum4Recursive(int[] nums, int target) {
        int result = 0;
        if(target<0){
        	return 0;
        }else if(target==0){
        	return 1;
        }
        for(int i=0; i<nums.length; i++){
        	result += combinationSum4(nums, target-nums[i]);
        }
        return result;
    }
}
