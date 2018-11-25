package com.qm.concurrent.Chapter6;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakTest {
    static class Student {
        public String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            return name != null ? name.equals(student.name) : student.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        HashMap<Student,String> map = new HashMap<>();

        WeakHashMap<Student, String> map = new WeakHashMap<>();

        Student student = new Student("qqq");

        map.put(student, "qqqqq");

        student = null;

        System.gc();
        Thread.sleep(1000);
        System.gc();
        Thread.sleep(1000);
        System.gc();
        Thread.sleep(1000);

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
