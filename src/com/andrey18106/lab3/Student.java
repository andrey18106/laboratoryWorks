package com.andrey18106.lab3;

import java.util.Comparator;

public class Student {
    private final int student_id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final double weight;

    public Student(int student_id, String firstName, String lastName, int age, double weight) {
        this.student_id = student_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[Student] " + this.getFullName() + " (" + this.age + ", " + this.weight + ")";
    }

    @Override
    public int hashCode() {
        return this.student_id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Student && this.student_id == ((Student) obj).student_id;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }
}


class StudentLastNameComparator implements Comparator<Student> {

    private boolean asc = true;

    public StudentLastNameComparator(boolean asc) {
        this.asc = asc;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (asc) {
            return (int)o1.getLastName().charAt(0) - (int)o2.getLastName().charAt(0);
        } else {
            return (int)o2.getLastName().charAt(0) - (int)o1.getLastName().charAt(0);
        }
    }
}

class StudentAgeComparator implements Comparator<Student> {

    private boolean asc = true;

    public StudentAgeComparator(boolean asc) {
        this.asc = asc;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (asc) {
            return o2.getAge() - o1.getAge();
        } else {
            return o1.getAge() - o2.getAge();
        }
    }
}

class StudentWeightComparator implements Comparator<Student> {

    private boolean asc = true;

    public StudentWeightComparator(boolean asc) {
        this.asc = asc;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (asc) {
            return (int) (o2.getWeight() - o1.getWeight());
        } else {
            return (int) (o1.getWeight() - o2.getWeight());
        }
    }
}