package com.andrey18106.lab2;

// #42 Продемонструйте у коді генерацію свого виключення AgeStudentException у конструкторі класу Student
// при спробі створити об'єкт зі значенням віку помилковим.
public class Student {
    String name;
    int age;

    public Student(String name, int age) throws AgeStudentException {
        this.name = name;
        if (age < 18) throw new AgeStudentException("Age must be 18 or higher.");
        this.age = age;
    }
}
