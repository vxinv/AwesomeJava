package org.vxinv.java_base.a1_basic_logic.c2_data_type;

public class String_literal {
    public static void main(String[] args) {
        String s11 = "a";
        String s22 = "bc";
        String s1 = "abc";
        String s2 = "a" + "bc";
        String s3 = new String("a") + "bc";
        String s4 = s11 + s22;

        // 当通过常量的形式使用一个字符串的时候，使用的就是常量池中的那个对应的String类型的对象。
        System.out.println(s1 == s2); // true
        // s3 新建的 String 对象
        System.out.println(s1 == s3); // false
        // 不通过常量引用 都会新建 String 对象
        System.out.println(s1 == s4); // false

        System.out.println(s1 == s4.intern()); // true
        System.out.println(s1.equals(s4)); // ture
    }

}
