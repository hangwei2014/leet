package com.grt.bsearch;

import com.alibaba.fastjson.JSON;
//153
public class FindMinimumInRotatedSortedArray {
	public static void main(String[] args){
		FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
		int[] nums = {3,1};
		int result = obj.findMin(nums);
		System.out.println("result:"+JSON.toJSONString(result));
	}
	public int findMin(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<right){
        	int mid = left + (right-left)/2;
        	if(nums[mid]<nums[right]){
        		right = mid;
        	}else{
        		left = mid+1;
        	}
        }
        return nums[left];
	}
	
}
