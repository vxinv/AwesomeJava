package org.vxinv.java_base.a6_dynamic_agent.c87_class_load;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class JavaSPITest {
    public static void main(String[] args) {
        ServiceLoader<Driver> load = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = load.iterator();
        while (iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println("driver: "+driver.getClass() + " load: "+ driver.getClass().getClassLoader());
            System.out.println("current thread contextload :"+Thread.currentThread().getContextClassLoader());
            System.out.println("ServiceLoader : "+ServiceLoader.class.getClassLoader());
        }
    }
}
