package com.grt.pointer;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.grt.recursive.Subsets;

public class ReverseLinklist {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.insert(0, 'a');
		sb.insert(0, 'b');
		sb.insert(0, 'c');
		System.out.println(sb);
		ReverseLinklist obj = new ReverseLinklist();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode n = obj.reverse(n1);
		while(n!=null){
			System.out.println("result:"+n.val);
			n = n.next;
		}
	}
	public ListNode reverse(ListNode head) {
		if(head==null || head.next==null){
			return head;
		}
		
		ListNode curNode = head.next;
		ListNode prevNode = head;
		head.next = null;
		while(curNode!=null){
			ListNode n3 = curNode.next;
			curNode.next = prevNode;
			prevNode = curNode;
			curNode = n3;
		}
		return prevNode;
	}
}
