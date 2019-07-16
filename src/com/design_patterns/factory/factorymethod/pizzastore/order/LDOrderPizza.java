package com.design_patterns.factory.factorymethod.pizzastore.order;

import com.design_patterns.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.design_patterns.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.design_patterns.factory.factorymethod.pizzastore.pizza.LDCheesePizza;
import com.design_patterns.factory.factorymethod.pizzastore.pizza.LDPepperPizza;
import com.design_patterns.factory.factorymethod.pizzastore.pizza.Pizza;


public class LDOrderPizza extends OrderPizza {

	
	@Override
	Pizza createPizza(String orderType) {
	
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		// TODO Auto-generated method stub
		return pizza;
	}

}
