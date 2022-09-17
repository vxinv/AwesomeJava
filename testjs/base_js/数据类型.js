console.log(1 + 2)
console.log((1 + 2) * 5 / 2)
console.log(2 / 0)
console.log(5 % 3)
console.log(10.3 % 3)

// 字符串是以单引号'或双引号"括起来的任意文本，比如'abc'，"xyz"等等。请注意，''或""本身只是一种表示方式，不是字符串的一部分，因此，字符串'abc'只有a，b，c这3个字符。

console.log("hello lixin")
console.log('hello world')
// 布尔值和布尔代数的表示完全一致，一个布尔值只有true、false两种值，要么是true，要么是false，可以直接用true、false表示布尔值，也可以通过布尔运算计算出来：
console.log(true)
console.log(true && false)
console.log(2 > 1)


// 要特别注意相等运算符==。JavaScript在设计时，有两种比较运算符：
// 第一种是==比较，它会自动转换数据类型再比较，很多时候，会得到非常诡异的结果；
// 第二种是===比较，它不会自动转换数据类型，如果数据类型不一致，返回false，如果一致，再比较。
console.log(false == 0)
console.log(false === 0)
// 另一个例外是NaN这个特殊的Number与所有其他值都不相等，包括它自己：
console.log(NaN)
console.log(NaN == NaN)
console.log(isNaN(NaN))
// 数组是一组按顺序排列的集合，集合的每个值称为元素。JavaScript的数组可以包括任意数据类型。例如：
var aa = [1, 2, 3.14, 'Hello', null, true];
console.log(aa)
var ab = new Array(1,"2",3)
console.log(ab)
// 对象
// JavaScript的对象是一组由键-值组成的无序集合，例如：
var person = {
    name: 'Bob',
    age: 20,
    tags: ['js', 'web', 'mobile'],
    city: 'Beijing',
    hasCar: true,
    zipcode: null
};
console.log(person.age)
console.log(person)
console.log(typeof person)
//同一个变量可以反复赋值，而且可以是不同类型的变量，但是要注意只能用var申明一次，例如：
var a = 123; // a的值是整数123
a = 'ABC'; // a变为字符串
var x = 10;
x = x + 2;
console.log(x)

let aaa = 1
function testaaa(){
    console.log(aaa)
    aaa = 2
    return aaa;
}
console.log(testaaa())
console.log(aaa)

var m = new Map();
var s = new Set();
console.log('你的浏览器支持Map和Set！');
// 1
//
console.log(null == null)
console.log(person.test === null)
console.log(person.test === undefined)
console.log(null == undefined)

var data = null;
console.log(typeof data); // "object"
console.log(typeof undefined)
