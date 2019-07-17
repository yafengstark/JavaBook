package com.design_patterns.visitor;

public class Man extends Person {

	@Override
	public void accept(Action action) {

		action.getManResult(this);
	}

}
