package com.andrey18106.lab3;

// Variant #3. Task number: 56

// Створіть модель, яка б дозволяла - розподіляти студентів по групам, переводити студентів з однієї групи в іншу, ✔
// отримувати склад групи відсортований за алфавітом, чи за вагою, чи за зростом. ✔
// Критерій сортування передається, як параметр методу. ✔
// Модель повинна дозволяти шукати студентів в групі за прізвищем ✔, фільтрувати за різними критеріями. ✔
// Критерії передаються як параметри методу фільтрації. ✔
// Виключити можливість додавання одного й того ж студента декілько разів у групу. ✔

public class lab3 {
    public static void main(String[] args) {
        Group group1 = new Group("209", new Student(1,"Andrey", "Borisenko", 20, 60));
        Group group2 = new Group("208",
                new Student(2,"Ivan", "Ivanov", 19, 70),
                new Student(3, "Igor", "Petrov", 19, 75),
                new Student(1, "Andrey", "Borisenko", 20, 60),
                new Student(4, "Maria", "Ivanova", 18, 55)
        );

        System.out.println(group1.getGroupList());
        System.out.println(group2.getGroupList());

        System.out.println("List sorted by last name:");
        System.out.println(group2.getGroupList(new StudentLastNameComparator(true)));
        System.out.println("List sorted by age:");
        System.out.println(group2.getGroupList(new StudentAgeComparator(false)));
        System.out.println("List sorted by weight:");
        System.out.println(group2.getGroupList(new StudentWeightComparator(false)));

        group2.moveTo(group2.getStudent("Ivanov"), group1);
        System.out.println("After move");
        System.out.println(group1.getGroupList());
        System.out.println(group2.getGroupList());

        System.out.println("Filtered lists:");
        System.out.println(group2.getGroupListByLastName("[C-I][a-z]*"));
        System.out.println(group2.getGroupListByWeight(60, true));
        System.out.println(group2.getGroupListByAge(20, true));

        Student student = group1.getStudent("Ivanov");
        group1.moveTo(student, group2);
        group2.addNewStudent(new Student(2,"Ivan", "Ivanov", 19, 70));
        System.out.println(group2.getGroupListByLastName("Ivanov[a-z]?"));
    }
}
