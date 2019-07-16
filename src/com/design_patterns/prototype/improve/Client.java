package com.design_patterns.prototype.improve;


/**
 *
 * 在创建新的对象时，总是需要重新获取原始对象的属性，如果创建的对象比较复杂
 时，效率较低
 3) 总是需要重新初始化对象，而不是动态地获得对象运行时的状态, 不够灵活

 让程序具有更高的效率和扩展性。

 */
public class Client {

	public static void main(String[] args) {
		System.out.println("原型模式完成对象的创建");

		Sheep sheep = new Sheep("tom", 1, "白色");

		/** friend是同一个对象 **/
		sheep.friend = new Sheep("jack", 2, "黑色");

		// 浅拷贝
		Sheep sheep2 = (Sheep)sheep.clone(); //克隆
		Sheep sheep3 = (Sheep)sheep.clone(); //克隆
		Sheep sheep4 = (Sheep)sheep.clone(); //克隆
		Sheep sheep5 = (Sheep)sheep.clone(); //克隆

		System.out.println("sheep2 =" + sheep2 + "sheep2.friend=" + sheep2.friend.hashCode());
		System.out.println("sheep3 =" + sheep3 + "sheep3.friend=" + sheep3.friend.hashCode());
		System.out.println("sheep4 =" + sheep4 + "sheep4.friend=" + sheep4.friend.hashCode());
		System.out.println("sheep5 =" + sheep5 + "sheep5.friend=" + sheep5.friend.hashCode());
	}

}
