### HashMap 常见面试题

##### 1 HashMap 存储键值对，实现了快速存取，K-V 都允许为Null

2 非同步，线程不安全 3 底层是Hash表，不保证有序

### 谈一下HashMap的底层原理是什么？

基于hashing的原理，jdk8后采用数组+链表+红黑树的数据结构。我们通过put和get存储和获取对象。当我们给put()方法传递键和 值时，先对键做一个hashCode()
的计算来得到它在bucket数组中的位置来存储Entry对象。当获取对象时，通过get获取到bucket 的位置，再通过键对象的equals()方法找到正确的键值对，然后在返回值对象。

### 谈一下hashMap中put是如何实现的？

+ 1 计算 key 的 hashCode 的哈希值 和 高16位 做异或运算 h = key.hashCode() ^ h >>> 16
+ 2 如果散列表为空 初始化
+ 3 如果没有发生碰撞 直接添加
+ 4 如果发生Hash碰撞
    -
        1. 如果Key的地址相同，或者equals相同，则替换
    -
        2. 红黑树和链表 分别插入
+ 5 如果通大于阈值，resize

### 谈一下hashMap中什么时候需要进行扩容，扩容resize()又是如何实现的？

- 1.初始化数组table
- 2.当数组table的size达到阙值时即++size > load factor * capacity 时，也是在putVal函数中
- 3.超过阙值会进行扩容操作，概括的讲就是扩容后的数组大小是原数组的2倍，将原来的元素重新hashing放入到新的散列表中去。
