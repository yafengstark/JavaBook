package com.design_patterns.principle.inversion;

public class DependecyInversion {

	public static void main(String[] args) {
		Person person = new Person();
		person.receive(new Email());
	}

}


class Email {
	public String getInfo() {
		return ": hello,world";
	}
}

/**
 * 比如
 * 扩展到微信，需要修改这个代码
 */
class Person {
	public void receive(Email email ) {
		System.out.println(email.getInfo());
	}
}
