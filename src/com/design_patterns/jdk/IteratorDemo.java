package com.design_patterns.jdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorDemo {

	public static void main(String[] args) {

		List<String> a = new ArrayList<>();
		a.add("jack");// ..
		// 获取到迭代器
		Iterator Itr = a.iterator();
		while (Itr.hasNext()) {
			System.out.println(Itr.next());
		}





	}

}
