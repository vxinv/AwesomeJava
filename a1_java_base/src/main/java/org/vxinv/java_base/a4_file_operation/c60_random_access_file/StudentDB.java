package org.vxinv.java_base.a4_file_operation.c60_random_access_file;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.vxinv.java_base.a4_file_operation.c57_DataInputOutputStream.Student;

public class StudentDB {

    public static ObjectMapper obm = new ObjectMapper();

    private static byte[] toBytes(Student student) throws IOException {
        return obm.writeValueAsBytes(student);
    }

    public static void saveStudents(Map<String, Student> students)
            throws IOException {
        BasicDB db = new BasicDB("src/main/java/org/vxinv/java_base/a4_file/c59_file_utils", "students");
        for (Map.Entry<String, Student> kv : students.entrySet()) {
            db.put(kv.getKey(), toBytes(kv.getValue()));
        }
        db.close();
    }

    @Test
    public void saveTest() {
        HashMap<String, Student> ssMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            Student student = new Student();
            student.setAge(i);
            student.setName("name" + i);
            student.setScore(i * 1.212);
            ssMap.put(i + "", student);
        }
        try {
            saveStudents(ssMap);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void getTest() throws IOException {
        BasicDB db = new BasicDB("src/main/java/org/vxinv/java_base/a4_file/c59_file_utils", "students");
        for (int i = 0; i < 10; i++) {
            byte[] bytes = db.get(i + "");
            Student student = obm.readValue(bytes, Student.class);
            System.out.println(obm.writeValueAsString(student));
        }
    }

}
