package org.vxinv.java_base.a2_object_oriented.c20_abstract_class;

// 5.2 抽象类
public abstract class AbstractAdder implements IAdd {

    @Override
    public void addAll(int[] numbers) {
        for(int num : numbers){
            add(num);
        }
    }
}
