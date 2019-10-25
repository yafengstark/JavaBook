- 节约内存原则

- - (1)尽量使用基本类型，而不是包装类型。
  - (2)斟酌字段类型，在满足容量前提下，尽量用小字段。
  - (3)如果可能，尽量用数组，少用集合。
  - (4)小技巧。



## Java对象结构



在java，对象占用的heap大小是8位对齐的。

对象在堆中分配的最新存储单位是8byte。如果存储的数据不够8byte的倍数，则对齐填充够8的倍数个字节。来自https://blog.csdn.net/jijianshuai/article/details/79128042。 未经验证



也就是说整数的类类型是基本类型内存的4倍。



- 时间用long/int表示，不用Date或者String。
- 短字符串如果能穷举或者转换成ascii表示，可以用long或者int表示。



一个Java对象在Heap的表示，可以分为三部分：

- Object Header
- Class Pointer
- Fields



## 参考

[一个 Java 对象到底有多大？](https://mp.weixin.qq.com/s/fQmNaqMAoMP4MePJOjbL0Q)



