package com.design_patterns.principle.single_responsibility;

/**
 *
 */
public class SingleResponsibility1 {

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.run("私家车");
		vehicle.run("公交车");

	}

}

/**
 * 交通工具类
 *
 * 违反了单一职责原则
 *
  */
class Vehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + " ....在公路上运行");
	}
}
