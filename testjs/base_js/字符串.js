var zy = 'I\'M \"OK\"'
console.log(zy)
var ac = '\u4e2d\u6587'
console.log(ac)
var dh =
    `这是一个
    多行
    字符串`;
console.log(dh)

var name = '小明';
var age = 20;
var message = '你好, ' + name + ', 你今年' + age + '岁了!';
console.log(message)
// 如果有很多变量需要连接，用+号就比较麻烦。ES6新增了一种模板字符串，表示方法和上面的多行字符串一样，但是它会自动替换字符串中的变量：
var name = '小明';
var age = 20;
var message = `你好, ${name}, 你今年${age}岁了!`;
console.log(message);

var s = 'Hello, world!';
s.length; // 13
console.log(s.length)

console.log(s.toUpperCase())
console.log(s.toLowerCase())
// indexOf()会搜索指定字符串出现的位置：
console.log(s.indexOf('world'))
console.log(s.indexOf('lo'))

// substring()返回指定索引区间的子串：
console.log(s.substring(0,3))
console.log(s.substring(7))


