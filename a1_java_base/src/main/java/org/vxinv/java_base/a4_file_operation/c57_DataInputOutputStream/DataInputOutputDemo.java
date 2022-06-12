package org.vxinv.java_base.a4_file_operation.c57_DataInputOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataInputOutputDemo {
    static String filePath = ".\\a1_java_base\\src\\main\\java\\org\\vxinv\\java_base\\a4_file_operation\\c57_DataInputOutputStream\\students.dat";
    public static void writeStudents(List<Student> students) throws IOException {
        File file = new File(filePath);
        file.deleteOnExit();
        DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
        output.writeInt(students.size());
        for (Student student : students) {
            output.writeUTF(student.getName());
            output.writeInt(student.getAge());
            output.writeDouble(student.getScore());
        }
    }


    public static List<Student> readStudents() throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream(filePath));
        try {
            int size = input.readInt();
            List<Student> students = new ArrayList<Student>(size);
            for (int i = 0; i < size; i++) {
                Student s = new Student();
                s.setName(input.readUTF());
                s.setAge(input.readInt());
                s.setScore(input.readDouble());
                students.add(s);
            }
            return students;
        } finally {
            input.close();
        }
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        List<Student> students = Arrays.asList(new Student("张三", 18, 80.9d), new Student("李四", 17, 67.5d));

        writeStudents(students);

        List<Student> list = readStudents();
        System.out.println(list);

    }

}
