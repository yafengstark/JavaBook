package com.design_patterns.proxy.staticproxy;

/**
 * 静态代理
 *
 * 代理对象与目标对象要实现相同的接口,
 * 然后通过调用相同的方法来调用目标对象的方法。
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建目标对象(被代理对象)
		TeacherDao teacherDao = new TeacherDao();

		//创建代理对象, 同时将被代理对象传递给代理对象
		TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

		//通过代理对象，调用到被代理对象的方法
		//即：执行的是代理对象的方法，代理对象再去调用目标对象的方法
		teacherDaoProxy.teach();
	}

}

