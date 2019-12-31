https://www.cnblogs.com/yejg1212/p/3270152.html

```java
package testpackage;
public class TestMain {
    public static void main(String[] args) {
        System.out.println(TestMain.class.getResource(""));
        System.out.println(TestMain.class.getResource("/"));
    }
}
```

output
```
file:/E:/workspace/Test/bin/testpackage/
file:/E:/workspace/Test/bin/
```


input

```java
package testpackage;
public class TestMain {
    public static void main(String[] args) {
        TestMain t = new TestMain();
        System.out.println(t.getClass());
        System.out.println(t.getClass().getClassLoader());
        // 输出编译结果根路径
        System.out.println(t.getClass().getClassLoader().getResource(""));
        System.out.println(t.getClass().getClassLoader().getResource("/"));//null
    }
}
```

输出结果：
```

class testpackage.TestMain
sun.misc.Launcher$AppClassLoader@1fb8ee3
file:/E:/workspace/Test/bin/
null
```
