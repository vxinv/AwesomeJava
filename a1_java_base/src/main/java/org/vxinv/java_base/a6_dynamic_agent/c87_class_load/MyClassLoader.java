package org.vxinv.java_base.a6_dynamic_agent.c87_class_load;

import java.io.IOException;

import org.vxinv.java_base.a4_file_operation.c57_DataInputOutputStream.BinaryFileReadWriteDemo;

public class MyClassLoader extends ClassLoader {

    private static final String BASE_DIR = "data/c87/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name.replaceAll("\\.", "/");
        fileName = BASE_DIR + fileName + ".class";
        try {
            byte[] bytes = BinaryFileReadWriteDemo.readFileToByteArray(fileName);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException ex) {
            throw new ClassNotFoundException("failed to load class " + name, ex);
        }
    }
}
