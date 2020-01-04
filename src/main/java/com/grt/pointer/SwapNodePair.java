package com.grt.pointer;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.grt.recursive.Subsets;

public class SwapNodePair {
	public static void main(String[] args) {
		SwapNodePair obj = new SwapNodePair();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode n = obj.swapPairs(n1);
		while(n!=null){
			System.out.println("result:"+n.val);
			n = n.next;
		}
	}
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null){
			return head;
		}
		
		ListNode newHead = head.next;
		ListNode curNode = head;
		while(curNode!=null){
			ListNode p1 = curNode;
			ListNode p2 = curNode.next;
			if(p2==null){
				break;
			}
			System.out.println("p1:"+p1.val+" p2:"+p2.val);
			curNode = p2.next;
			p1.next = p2.next.next==null?p2.next:p2.next.next;
			p2.next = p1;
		}
		return newHead;
	}
}
