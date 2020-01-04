package com.grt.index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import com.alibaba.fastjson.JSON;

public class HIndex {
	public static void main(String[] args) {
		HIndex obj = new HIndex();
		Integer[] s = {0, 1, 2, 3, 5, 6, 6};
		int result = obj.hIndex(s);
		System.out.println("result:"+JSON.toJSONString(result));
	}
	public int hIndex(Integer[] citations) {
		int hIndex = 0;
		Arrays.sort(citations, Collections.reverseOrder());
        for(int i = 0; i<citations.length; i++){
        	System.out.println("hIndex:"+hIndex+" citations:"+citations[i]);
            if(citations[i]>=hIndex)
            	hIndex++;
        }
        return hIndex;
    }

	
}
