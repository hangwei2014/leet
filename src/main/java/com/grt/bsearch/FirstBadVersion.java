package com.grt.bsearch;

import com.alibaba.fastjson.JSON;

//278
public class FirstBadVersion {
	public static void main(String[] args){
		FirstBadVersion obj = new FirstBadVersion();
		int result = obj.firstBadVersion(5);
		System.out.println("result:"+JSON.toJSONString(result));
	}

	public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while(left<=right){
        	int mid = left+(right-left)/2;
        	if(isBadVersion(mid)){
        		right = mid-1;
        	}else{
        		left = mid+1;
        	}
        }
		return left;
    }
	
	boolean isBadVersion(int v){
		if(v>=4){
			return true;
		}else{
			return false;
		}
	}
}
