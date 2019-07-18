package com.design_patterns.factory.absfactory.pizzastore.order;

import com.design_patterns.factory.absfactory.pizzastore.pizza.Pizza;


//一个抽象工厂模式的抽象层(接口)

/**
 * 单个的简单工厂类变成了工厂簇
 */
public interface AbsFactory {

	//让下面的工厂子类来 具体实现
	Pizza createPizza(String orderType);


}

