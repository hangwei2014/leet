package com.grt.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

public class FactorCombinations {
	public static void main(String[] args){
		FactorCombinations obj = new FactorCombinations();
		obj.getFactors(12);
		System.out.println("result:"+JSON.toJSONString(obj.result));
	}
	
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	Stack stack = new Stack();
	
	public void getFactors(int n) {
        if (n <= 1) {
            return;
        }
        dfs(2, n);
    }
    	
    private void dfs(int begin, int n) {
        if (n == 1) {
            result.add(new ArrayList<Integer>(stack));
            return;
        }
        
        for (int i = begin; i <= n; i++) {
            if (n % i == 0) {
            	stack.add(i);
                dfs(i, n / i);
                stack.pop();
            }
        }
    }
    }
