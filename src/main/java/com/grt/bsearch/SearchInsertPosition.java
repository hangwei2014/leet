package com.grt.bsearch;

//35
public class SearchInsertPosition {
	public static void main(String[] args){
		SearchInsertPosition obj = new SearchInsertPosition();
		int[] nums = {1,3,5,6};
		int target = 2;
		int result = obj.searchInsert(nums, target);
		System.out.println("result:"+result);
	}
	
	public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
        	int mid = left + (right-left)/2;
        	if(nums[mid]==target){
        		return mid;
        	}else if(nums[mid]>target){
        		right = mid-1;
        	}else if(nums[mid]<target){
        		left = mid+1;
        	}
        }
        return left;
    }
}
