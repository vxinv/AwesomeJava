package org.vxinv.java_base.a2_object_oriented.c20_abstract_class;

import java.util.ArrayList;
import java.util.List;

public class TestAbs {
    public static void main(String[] args) {
        AbstractPerson abstractPerson = new AbstractPerson() {
            @Override
            void add(List<Person> peoples) {
                Person lixin_test = new Person("lixin_test");
                peoples.add(lixin_test);
                this.peoples=peoples;
            }
        };

        abstractPerson.add(new ArrayList<Person>());
    }

}
