package com.andrey18106.lab2;

// Variant #3. Task numbers: 42, 39, 38, 51, 33

// #42 Продемонструйте у коді генерацію свого виключення AgeStudentException у конструкторі класу Student
// при спробі створити об'єкт зі значенням віку помилковим.

// #39 Продемонструйте у коді  2 способа  обробки виключних ситуацій у методі (з try-catch и  throws),
// а також особливості використання блока finally.
// У якості обробляємо виключення оберіть будь яке =checked= виключення.

// #38 Продемонстрируйте при перехопленні виключення ArithmeticException,
// можливості усунути помилку у даних та виконати завдання у повному обсязі.

// #51 На тестовому прикладі продемонструйте відмінності використання змінних, методів звичайних
// та static методів та змінних. Використовуйте модель, яка потребує підраховувати
// кількість створених об'єктів певного типу, використайте для цього static-змінні.

// #33 Створіть enum Посади, яке відповідає можливій структурі посад підприємства.
// Продемонструйте можливість задавати властивості, конструктори та методи в enum.
// Забезпечте при цьому можливості змінювати посадові оклади та кількість днів відпустки.

public class lab2 {

    enum Position {
        Director(5000, 31),
        TeamLead(3600, 21),
        GeneralSystemAnalytic(2500, 21),
        SystemAnalytic(2100, 14),
        Programmer(1700, 14);
        private int salary;
        private int weekends;
        Position(int salary, int weekends) {
            this.salary = salary;
            this.weekends = weekends;
        }
        public String toString() {
            return "Position [" + this.name() + "]: $" + salary + " (weekends: " + weekends + ")";
        }
        public void setSalary(int value) {
            this.salary = value;
        }
        public void setWeekends(int value) {
            this.weekends = value;
        }
        public int getWeekends() {
            return this.weekends;
        }
    }

    public static void main(String[] args) throws AgeStudentException {
        // ---------- #39 ----------
        studentCreationWithTryCatch();
        studentCreationWithThrows();

        // ---------- #38 ----------
        // #38 Продемонстрируйте при перехопленні виключення ArithmeticException,
        // можливості усунути помилку у даних та виконати завдання у повному обсязі.
        int res;
        int x = 20;
        int y = 0;
        try {
            res = x / y;
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        } finally {
            res = x;
        }
        System.out.println("Res = " + res);

        // ---------- #38 ----------
        // #51 На тестовому прикладі продемонструйте відмінності використання змінних, методів звичайних
        // та static методів та змінних. Використовуйте модель, яка потребує підраховувати
        // кількість створених об'єктів певного типу, використайте для цього static-змінні.
        SomeModel someModel = new SomeModel(1);
        SomeModel someModel1 = new SomeModel(2);
        SomeModel someModel2 = new SomeModel(3);
        System.out.println("SomeModel Static field: " + SomeModel.someStaticField);
        System.out.println("SomeModel0 Public field: " + someModel.getSomeField());
        System.out.println("SomeModel1 Public field: " + someModel1.getSomeField());
        System.out.println("SomeModel2 Public field: " + someModel2.getSomeField());

        // ---------- #33 ----------
        // #33 Створіть enum Посади, яке відповідає можливій структурі посад підприємства.
        // Продемонструйте  можливість задавати властивості, конструктори та методи в enum.
        // Забезпечте при цьому можливості змінювати посадові оклади та кількість днів відпустки.
        System.out.println(Position.Programmer);
        System.out.println(Position.Director.getWeekends());
        Position directorPos = Position.Director;
        directorPos.setSalary(4500);
        directorPos.setWeekends(21);
        System.out.println(directorPos);
    }

    private static void studentCreationWithThrows() throws AgeStudentException {
        Student student = new Student("Andrey", 18);
    }

    private static void studentCreationWithTryCatch() {
        try {
            Student student = new Student("Andrey", 10);
        } catch (AgeStudentException e) {
            e.printStackTrace();
        }
    }
}
