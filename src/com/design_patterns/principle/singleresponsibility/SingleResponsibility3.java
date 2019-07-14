package com.design_patterns.principle.singleresponsibility;

public class SingleResponsibility3 {

	public static void main(String[] args) {

		Vehicle2 vehicle2  = new Vehicle2();
		vehicle2.run("汽车");
		vehicle2.runWater("船");
		vehicle2.runAir("飞机");
	}

}

/**
 * 虽然在类这个级别上没有遵守单一职责原则
 * 但是在方法级别做到了
 */
class Vehicle2 {
	public void run(String vehicle) {


		System.out.println(vehicle + " 在路上");

	}

	public void runAir(String vehicle) {
		System.out.println(vehicle + " 天空.");
	}

	public void runWater(String vehicle) {
		System.out.println(vehicle + "海洋");
	}

}
