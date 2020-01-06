package com.grt.bsearch;

import com.alibaba.fastjson.JSON;
//154
public class FindMinimumInRotatedSortedArray2 {
	public static void main(String[] args){
		FindMinimumInRotatedSortedArray2 obj = new FindMinimumInRotatedSortedArray2();
		int[] nums = {3,1,2,3,3,3,3};
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
        	}else if(nums[mid]>nums[right]){
        		left = mid+1;
        	}else{
        		right--;
        	}
        }
        return nums[left];
	}
}
