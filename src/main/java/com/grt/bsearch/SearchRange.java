package com.grt.bsearch;

import com.alibaba.fastjson.JSON;

//34
public class SearchRange {
	public static void main(String[] args){
		SearchRange obj = new SearchRange();
		//int[] nums = {5,7,7,8,8,10};
		int[] nums = {8,8};
		int target = 8;
		int[] result = obj.searchRange(nums, target);
		System.out.println("result:"+JSON.toJSONString(result));
	}
	
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
        int left = 0;
        int right = nums.length-1;
        int pos = -1;
        while(left<=right){
        	int mid = left + (right-left)/2;
        	if(nums[mid]==target){
        		pos = mid;
        		break;
        	}else if(nums[mid]>target){
        		right = mid-1;
        	}else{
        		left = mid+1;
        	}
        }
        
        if(pos==-1){
        	return new int[]{-1, -1};
        }
        //find right boundary
        left = pos;
        right = nums.length-1;
        while(left<=right){
        	int mid = left + (right-left)/2;
        	if(nums[mid]==target){
        		left = mid+1;
        	}else{
        		right = mid-1;
        	}
       }
        result[1]=right;
        
        //find left boundary
        left = 0;
        right = pos;      
        while(left<=right){
        	int mid = left + (right-left)/2;
        	if(nums[mid]==target){
        		right = mid-1;
        	}else{
        		left = mid+1;
        	}
        }
        result[0]=left;

        return result;
    }
}
