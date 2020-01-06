package com.grt.bsearch;

//704
public class BinarySearch {
	public static void main(String[] args){
		BinarySearch obj = new BinarySearch();
		int[] nums = {1,3};
		int target = 3;
		int result = obj.search(nums, target);
		System.out.println("result:"+result);
	}
	
	public int search(int[] nums, int target) {
        if(nums.length==0){
        	return -1;
        }
        int left = 0;
        int right = nums.length-1;
        
        while(right>=left){
            int mid = left+(right-left)/2;
        	if(nums[mid]==target){
        		return mid;
        	}else if(nums[mid]>target){
        		right = mid-1;
        	}else{
        		left = mid+1;
        	}
        }
        return -1;
    }
}
