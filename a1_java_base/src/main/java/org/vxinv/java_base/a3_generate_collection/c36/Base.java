package org.vxinv.java_base.a3_generate_collection.c36;

// 8.2 解析通配符
public class Base implements Comparable<Base> {
    private int sortOrder;

    public Base(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public int compareTo(Base o) {
        if (sortOrder < o.sortOrder) {
            return -1;
        }else if(sortOrder > o.sortOrder){
            return 1;
        }else{
            return 0;
        }
    }
}
