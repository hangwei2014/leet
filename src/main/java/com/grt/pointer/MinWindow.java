package com.grt.pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

public class MinWindow {
	public static void main(String[] args) {
		MinWindow obj = new MinWindow();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println("s:"+s);
		String result = obj.minWindow(s, t);
		System.out.println("result:"+JSON.toJSONString(result));
	}
	HashMap<Character, Integer> tMap = new HashMap();
	HashMap<Character, Integer> sMap = new HashMap();

	public String minWindow(String s, String t) {
		String res = "";
		int left = 0;
		int needCnt = t.length();
		int minLen = Integer.MAX_VALUE;
		
		for(int i=0; i<t.length(); i++){
			Character c = t.charAt(i);
			tMap.put(c, tMap.getOrDefault(c, 0)+1);
		}
		System.out.println("tMap:"+JSON.toJSONString(tMap));
		
		for(int i=0; i<s.length(); i++){		
			Character curChar = s.charAt(i);
			if(!tMap.containsKey(curChar)) continue;
			int tCnt = tMap.get(curChar);
			int sCnt = sMap.getOrDefault(curChar, 0)+1;
			if(sCnt<=tCnt){
				needCnt--;
			}
			sMap.put(curChar, sCnt);
			//this loop is to move left pointer
			while(needCnt==0){
				if(minLen > i-left){
					minLen = i-left;
					res = s.substring(left, i+1);
				}
				Character leftChar = s.charAt(left);
				if(tMap.containsKey(leftChar)){
					tCnt = tMap.get(leftChar);
					sCnt = sMap.get(leftChar);
					if(sCnt-1<tCnt){
						needCnt++;
					}
					sMap.put(leftChar, sCnt-1);
				}
				left++;
				System.out.println("i:"+i+" left:"+left);
			}		
		}
		return res;
	}
	
}

