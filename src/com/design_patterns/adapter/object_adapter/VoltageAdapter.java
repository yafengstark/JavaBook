package com.design_patterns.adapter.object_adapter;

//适配器类

/**
 * ) 根据“合成复用原则”，在系统中尽量使用关联关系来替代继承关系。
 3) 对象适配器模式是适配器模式常用的一种
 */
public class VoltageAdapter  implements IVoltage5V {

	private Voltage220V voltage220V; // 关联关系-聚合


	//通过构造器，传入一个 Voltage220V 实例
	public VoltageAdapter(Voltage220V voltage220v) {

		this.voltage220V = voltage220v;
	}



	@Override
	public int output5V() {

		int dst = 0;
		if(null != voltage220V) {
			int src = voltage220V.output220V();//获取220V 电压
			System.out.println("使用对象适配器，进行适配~~");
			dst = src / 44;
			System.out.println("适配完成，输出的电压为=" + dst);
		}

		return dst;

	}

}
