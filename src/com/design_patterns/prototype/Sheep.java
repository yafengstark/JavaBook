package com.design_patterns.prototype;


import java.util.HashMap;
import java.util.Map;

/**
 *
 在创建新的对象时，总是需要重新获取原始对象的属性，如果创建的对象比较复杂
 时，效率较低
 3) 总是需要重新初始化对象，而不是动态地获得对象运行时的状态, 不够灵活

 */
public class Sheep {
    private String name;
    private int age;
    private String color;
    public Sheep(String name, int age, String color) {
        super();
        this.name = name;
        this.age = age;
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Sheep [name=" + name + ", age=" + age + ", color=" + color + "]";
    }


}
