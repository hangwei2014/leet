package com.grt.bsearch;

import com.alibaba.fastjson.JSON;

//33
public class SearchRotatedSortedArray {
	public static void main(String[] args){
		SearchRotatedSortedArray obj = new SearchRotatedSortedArray();
		int[] nums = {3,1};
		int result = obj.search(nums, 1);
		System.out.println("result:"+JSON.toJSONString(result));
	}

    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
        	int mid = left+(right-left)/2;
        	System.out.println(" left:"+left+" right:"+right+" mid:"+mid+" nums[mid]:"+nums[mid]);
        	if(nums[mid]==target){
        		return mid;
        	}

        	//left half increasing
        	if(nums[mid]>=nums[left]){ // >= !!!
        		if(nums[mid]>target && target>=nums[left]){
        			right = mid-1;
        		}else{
        			left = mid+1;
        		}
        	}else{ //right half increasing
        		if(nums[mid]<target && target<=nums[right]){
        			left = mid+1;
        		}else{
        			right = mid-1;
        		}
        	}
        }
        if(left>=0 && left<nums.length && nums[left]==target){
        	return left;
        }else if(right>=0 && right<nums.length && nums[right]==target){
        	return right;
        }else{
        	return -1;
        }
    }

}
