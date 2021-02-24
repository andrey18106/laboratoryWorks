package com.andrey18106.lab3;

import java.util.*;

public class Group {
    private final String name;
    private final HashSet<Student> students = new HashSet<>();

    public Group(String groupName, Student... students) {
        this.name = groupName;
        if (students.length > 0) {
            this.students.addAll(Arrays.asList(students));
        }
    }

    public void moveTo(Student student, Group group) {
        if (group.addNewStudent(student)) {
            this.students.remove(student);
        }
    }

    public boolean addNewStudent(Student student) {
        if (!this.students.contains(student)) {
            return this.students.add(student);
        } else {
            return false;
        }
    }

    public Student getStudent(String lastName) {
        for (Student student : this.students) {
            if (student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getGroupList() {
        StringBuilder groupList = new StringBuilder("Group " + this.name + " list:\n");
        for (Student student : this.students) {
            groupList.append(student.getFullName()).append("\n");
        }
        return groupList.toString();
    }

    public String getGroupList(Comparator<Student> comparator) {
        List<Student> sorted = new ArrayList<>(this.students);
        sorted.sort(comparator);
        StringBuilder groupList = new StringBuilder("Group " + this.name + " sorted by Last Name list:\n");
        for (Student student : sorted) {
            groupList.append(student.getFullName()).append("\n");
        }
        return groupList.toString();
    }

    public String getGroupListByFirstName(String pattern) {
        StringBuilder groupList = new StringBuilder("Group " + this.name + " sorted by Last Name list:\n");
        for (Student student : this.students) {
            if (student.getFirstName().matches(pattern)) {
                groupList.append(student.getFullName()).append("\n");
            }
        }
        return groupList.toString();
    }

    public String getGroupListByLastName(String pattern) {
        StringBuilder groupList = new StringBuilder("Group " + this.name + " sorted by Last Name list:\n");
        for (Student student : this.students) {
            if (student.getLastName().matches(pattern)) {
                groupList.append(student.getFullName()).append("\n");
            }
        }
        return groupList.toString();
    }

    public String getGroupListByAge(int condition, boolean higher) {
        StringBuilder groupList = new StringBuilder("Group " + this.name + " list filtered by Student Age:\n");
        for (Student student : this.students) {
            if (higher) {
                if (student.getAge() >= condition) {
                    groupList.append(student.getFullName()).append("\n");
                }
            } else {
                if (student.getAge() <= condition) {
                    groupList.append(student.getFullName()).append("\n");
                }
            }
        }
        return groupList.toString();
    }

    public String getGroupListByWeight(int condition, boolean higher) {
        StringBuilder groupList = new StringBuilder("Group " + this.name + " list filtered by Student Weight:\n");
        for (Student student : this.students) {
            if (higher) {
                if (student.getWeight() > condition) {
                    groupList.append(student.getFullName()).append("\n");
                }
            } else {
                if (student.getWeight() < condition) {
                    groupList.append(student.getFullName()).append("\n");
                }
            }
        }
        return groupList.toString();
    }
}