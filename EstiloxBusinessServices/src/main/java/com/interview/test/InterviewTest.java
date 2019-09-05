package com.interview.test;

import java.util.Iterator;
import java.util.TreeSet;

public class InterviewTest extends Demo{

	public static void main(String[] args) {
		/*System.out.println("Integer :: "+Integer.MIN_VALUE+" , "+Integer.MAX_VALUE);
		System.out.println("Double :: "+Double.MIN_VALUE+" , "+Double.MAX_VALUE);
		System.out.println(Math.max(Double.MIN_VALUE, -0.0d));*/
		/*InterviewTest interviewTest = new InterviewTest();
		System.out.println(interviewTest.getName());*/
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(10);
		treeSet.add(5);
		treeSet.add(8);
		Iterator<Integer> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		/*HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(10);
		hashSet.add(5);
		hashSet.add(8);
		Iterator<Integer> iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
		
		/*LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add(10);
		linkedHashSet.add(5);
		linkedHashSet.add(8);
		Iterator<Integer> iterator = linkedHashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
	}

	
	
}


class Demo{
	String getName() {
		return "Kamesh";
	}
}