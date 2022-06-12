package org.vxinv.java_base.a2_object_oriented.c21_inner_class.anonymous;

import org.vxinv.java_base.a2_object_oriented.c14_combination_of_classes.Point;
// 5.3 内部类
public class Outer {
    public void test(final int x, final int y){
        Point p = new Point(2,3){

            @Override
            public double distance() {
                return distance(new Point(x,y));
            }
        };

        System.out.println(p.distance());
    }

}
