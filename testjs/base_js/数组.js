var arr = [1,2,3,14,'hello',]
console.log(arr.length)

var aa = [1,2,3]
aa[5] = 'x'
console.log(aa)
console.log(typeof aa[3])
// 与String类似，Array也可以通过indexOf()来搜索一个指定的元素的位置：
var arr = [10, 20, '30', 'xyz'];
console.log(arr.indexOf(20)); // 元素10的索引为0
// slice()就是对应String的substring()版本，它截取Array的部分元素，然后返回一个新的Array：
var arr = ['A', 'B', 'C', 'D', 'E', 'F', 'G'];
var a1 = arr.slice(0, 3); // 从索引0开始，到索引3结束，但不包括索引3: ['A', 'B', 'C']
console.log(a1)
var a2 = arr.slice(3); // 从索引3开始到结束: ['D', 'E', 'F', 'G']
console.log(a2)
// push()向Array的末尾添加若干元素，pop()则把Array的最后一个元素删除掉：
var arr = [1, 2];
arr.push("3")
console.log(arr)
arr.pop();arr.pop();
console.log(arr)
// 如果要往Array的头部添加若干元素，使用unshift()方法，shift()方法则把Array的第一个元素删掉：
var arr = [1, 2];
arr.unshift('A', 'B'); // 返回Array新的长度: 4
console.log(arr); // ['A', 'B', 1, 2]
arr.shift(); // 'A'
console.log(arr); // ['B', 1, 2]
arr.shift(); arr.shift(); arr.shift(); // 连续shift 3次
console.log(arr); // []
arr.shift(); // 空数组继续shift不会报错，而是返回undefined
console.log(arr); // []


