package org.vxinv.java_base.a2_object_oriented.c20_abstract_class;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
        System.out.println(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
