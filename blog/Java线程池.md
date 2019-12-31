



二、使用线程池有什么优点

三、线程池的四种使用方式
1、newCachedThreadPool
不足：这种方式虽然可以根据业务场景自动的扩展线程数来处理我们的业务，但是最多需要多少个线程同时处理缺是我们无法控制的；

优点：如果当第二个任务开始，第一个任务已经执行结束，那么第二个任务会复用第一个任务创建的线程，并不会重新创建新的线程，提高了线程的复用率；

2、newFixedThreadPool

3、newScheduledThreadPool

4、newSingleThreadExecutor





## 参考
[Java线程池的四种用法与使用场景](https://mp.weixin.qq.com/s/QAv5MJyE76dv45QW3-sNDg)

