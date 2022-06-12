##### 原理
其实是 Thread 的内部有一个Map ，对于每个 ThreadLocal 对象，调用Get Set 其实是以 ThreadLocal 为键值读取Value

##### 遇到的问题 
在线程池使用时 需要在使用后 remove  
[参考]:https://www.cnblogs.com/qifenghao/p/8977378.html