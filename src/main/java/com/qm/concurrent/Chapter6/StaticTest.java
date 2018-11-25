package com.qm.concurrent.Chapter6;

public class StaticTest {

    static class Student{
        static String name = "name";

        public static String getName() {
            return name;
        }

        public static void setName(String name) {
            Student.name = name;
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student = null;
        System.out.println(Student.getName());
    }
}
