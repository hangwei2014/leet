package com.grt.bsearch;

//162
public class FindPeakElement {
	public static void main(String[] args){
		FindPeakElement obj = new FindPeakElement();
		//int[] nums = {1,2,1,3,5,6,4};
		int[] nums = {1,2};
		int result = obj.findPeakElement(nums);
		System.out.println("result:"+result);
	}

    public int findPeakElement(int[] nums) {
    	if(nums.length==1){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
        	int mid = left+(right-left)/2;
    		System.out.println("mid:"+mid+" left:"+left+" right:"+right);
    		if(mid==nums.length-1){
    			return nums.length-1;
    		}
        	if(nums[mid]>nums[mid+1]){
        		right = mid-1;
        	}else{
        		left = mid+1;
        	}
        }
        return left;
    }

    public int findPeakElement2(int[] nums) {
        if(nums.length==1){
            return 0;
        }else if(nums.length>=2){
            if(nums[0]>nums[1]){
                return 0;
            }else if(nums[nums.length-1]>nums[nums.length-2]){
                return nums.length-1;
            }
        }
        for(int i=2; i<nums.length; i++){
        	if(nums[i-1]>nums[i-2] && nums[i-1]>nums[i]){
        		return i-1;
        	}
        }
        return -1;
    }

}
