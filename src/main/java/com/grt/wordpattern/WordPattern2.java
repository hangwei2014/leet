package com.grt.wordpattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern2 {
	public static void main(String[] args){
		WordPattern2 obj = new WordPattern2();
		String str = "redblueredblue";
		String pattern = "abab";
		boolean result = obj.wordPatternMatch(pattern, str);
		System.out.println("result:"+result);
		result = obj.wordPatternMatch("aabb", "xyzabcxzyabc");
		System.out.println("result:"+result);
		result = obj.wordPatternMatch("aaaa", "asdasdasdasd");
		System.out.println("result:"+result);
		result = obj.wordPatternMatch("abca", "assassaasa");
		System.out.println("result:"+result);
		result = obj.wordPatternMatch("aba", "asaasa");
		System.out.println("result:"+result);
	}
    Map<Character, Integer> map2 = new HashMap();
	
	public boolean wordPatternMatch(String pattern, String str) {
	    Map<Character, String> map = new HashMap();
	    Set<String> set = new HashSet();
	    return isMatch(str, 0, pattern, 0, map, set);
	  }

	  boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
	    if (i == str.length() && j == pat.length()) return true;
	    if (i == str.length() || j == pat.length()) return false;

	    char c = pat.charAt(j);
	    if (map.containsKey(c)) {
	      String s = map.get(c);
	      if (!str.startsWith(s, i)) {
	        return false;
	      }
	      // if it can match, great, continue to match the rest
	      return isMatch(str, i + s.length(), pat, j + 1, map, set);
	    }

	    // pattern character does not exist in the map
	    for (int k = i; k < str.length(); k++) {
	      String p = str.substring(i, k + 1);
	      
	      map.put(c, p);
	      Integer cnt = map2.getOrDefault(c, 0);
	      map2.put(c, cnt+1);
	      // continue to match the rest
	      if (isMatch(str, k + 1, pat, j + 1, map, set)) {
	        return true;
	      }
	      cnt = map2.get(c);
	      if(cnt==1){
	    	  map.remove(c);
	      }else{
	    	  map2.put(c, cnt-1);
	      }
	    }

	    // we've tried our best but still no luck
	    return false;
	  }

}
