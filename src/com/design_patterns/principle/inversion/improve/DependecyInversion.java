package com.design_patterns.principle.inversion.improve;

public class DependecyInversion {

	public static void main(String[] args) {

		Person person = new Person();
		person.receive(new Email());
		
		person.receive(new WeiXin());
	}

}


interface IReceiver {
	public String getInfo();
}

class Email implements IReceiver {
	public String getInfo() {
		return "�����ʼ���Ϣ: hello,world";
	}
}


class WeiXin implements IReceiver {
	public String getInfo() {
		return "΢����Ϣ: hello,ok";
	}
}


class Person {

	public void receive(IReceiver receiver ) {
		System.out.println(receiver.getInfo());
	}
}
