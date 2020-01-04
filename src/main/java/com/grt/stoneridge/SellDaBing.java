package com.grt.stoneridge;

import java.util.LinkedList;
import java.util.Queue;

import com.alibaba.fastjson.JSON;

public class SellDaBing {
	public static void main(String[] args){
		System.out.println("result:"+new SellDaBing().sell(new Integer[]{10, 5, 20})); //true
		System.out.println("result:"+new SellDaBing().sell(new Integer[]{10, 5, 20, 10})); //false
		System.out.println("result:"+new SellDaBing().sell(new Integer[]{5, 20, 5, 5, 10, 10})); // true
		System.out.println("result:"+new SellDaBing().sell(new Integer[]{5, 20, 5, 5, 10, 10, 10, 5})); //false
		System.out.println("result:"+new SellDaBing().sell(new Integer[]{5, 20, 5, 5, 10, 10, 5, 10})); //true
		System.out.println("result:"+new SellDaBing().sell(new Integer[]{10, 5, 20, 10, 5, 5})); //true
	}
	
	Queue<Integer> q5 = new LinkedList();
	Queue<Integer> q10 = new LinkedList();
	Queue<Integer> q20 = new LinkedList();
	Integer cnt5 = 0;
	Integer cnt10 = 0;
	Integer cnt20 = 0;
	
	boolean sell(Integer[] orders){
		putInQueue(orders);
		for(int i=0; i<orders.length; i++){
			if(!sellNext()){
				return false;
			}
		}
		return true;
	}
	
	void putInQueue(Integer[] orders){
		for(Integer i=0; i<orders.length; i++){
			Integer order = orders[i];
			if(order==5){
				q5.add(i);
			}else if(order==10){
				q10.add(i);
			}else if(order==20){
				q20.add(i);
			}
		}
	}
	
	boolean sellNext(){
		Integer head5 = q5.peek();
		Integer head10 = q10.peek();
		Integer head20 = q20.peek();
		if(head5!=null && (head10==null || head5<=head10+5) && (head20==null || head5<=head20+5)){
			q5.poll();
			cnt5++;
		}else if(head10!=null && (head20==null || head10<=head20+5)){
			q10.poll();
			cnt10++;
			cnt5--;
		}else if(head20!=null){
			q20.poll();
			if(head10!=null && head5!=null){
				cnt10--;
				cnt5--;
			}else if(head5!=null){
				cnt5 -= 3;
			}
		}
		if(cnt5<0){
			return false;
		}else{
			return true;
		}
	}
}



