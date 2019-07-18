package com.design_patterns.principle.single_responsibility;

public class SingleResponsibility2 {

	public static void main(String[] args) {

		RoadVehicle roadVehicle = new RoadVehicle();
		roadVehicle.run("汽车");
		roadVehicle.run("摩托车");
		
		AirVehicle airVehicle = new AirVehicle();
		
		airVehicle.run("飞机");
	}

}


class RoadVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "路上跑");
	}
}

class AirVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "天空");
	}
}

class WaterVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "海上");
	}
}