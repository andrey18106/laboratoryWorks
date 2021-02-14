package com.andrey18106.lab1;

// Variant #3. Task numbers: 25, 4, 12, 3, 20

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class lab1 {

    public static void main(String[] args) {

        // ---------- #3 ----------
        int[] someArr = new int[] {1, 2, 3, 4, 5};
        int[] newArr = InsertNumberToArr(6, 2, someArr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }

        // ---------- #12 ----------
        int[] sortedArr = InsertionSort(newArr);
        System.out.println();
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + " ");
        }

        // ---------- #4 ----------
        int[] newArr1 = DeleteFromArr(1, sortedArr);
        System.out.println();
        for (int i = 0; i < newArr1.length; i++) {
            System.out.print(newArr1[i] + " ");
        }

        // ---------- #20 ----------
        System.out.println("\n" + CalculateVowelLetters("Привіт, світ!"));

        // ---------- #25 ----------
        System.out.println(CalculateDaysFromYearsBeginning("13.01.21"));
        System.out.println(CalculateDaysFromYearsBeginning2("14.01-21"));
    }

    // #3:
    // Створіть метод, який дозволяє вставляти в будь яку позицію масиву будь яке число.
    // Метод повинен повертати новий масив.
    public static int[] InsertNumberToArr(int newItem, int insertIndex, int[] arr) {
        if (arr.length == 0)
            return null;

        int[] resultArr = new int[arr.length + 1];

        for (int i = 0; i <= insertIndex; i++) {
            resultArr[i] = arr[i];
        }
        resultArr[insertIndex + 1] = newItem;
        for (int i = insertIndex + 2; i <= arr.length; i++) {
            resultArr[i] = arr[i - 1];
        }

        return resultArr;
    }

    // #4:
    // Створіть метод, який дозволяє видаляти будь який елемент по індексу в одновимірному масиві int[]
    // Новий масив повинен повертатися з методу.
    public static int[] DeleteFromArr(int deleteIndex, int[] arr) {
        if (arr.length == 0 && (!(deleteIndex <= arr.length) || !(deleteIndex >= 0)))
            return null;

        int[] resultArr = new int[arr.length - 1];

        for (int i = 0; i < deleteIndex; i++) {
            resultArr[i] = arr[i];
        }
        for (int i = deleteIndex; i < arr.length - 1; i++) {
            resultArr[i] = arr[i + 1];
        }

        return resultArr;
    }

    // #12:
    // Створіть метод, який сортує будь який масив int[] методом вставок.
    public static int[] InsertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    // #20:
    // Створіть метод, який може підрахувати кількість голосних букв у будь якому слові (мова українська)
    public static int CalculateVowelLetters(String word) {
        int count = 0;
        String vowelLetters = "аеиіоуяюєї";
        for (int i = 0; i < word.length(); i++) {
            if (vowelLetters.indexOf(word.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    // #25:
    // Створіть метод, який приймає параметр String у форматі "11.01.21"
    // та повертає кількість діб з початку року до цієї дати.
    // Ви повинні врахувати, що у лютому може бути різна кількість дат.
    public static long CalculateDaysFromYearsBeginning(String date) {
        String dateFormatRegex = "^([0-2][0-9]|3[0-1])\\.(0[0-9]|1[0-2])\\.([0-9][0-9])?[0-9][0-9]$";
        if (!(date.matches(dateFormatRegex)))
            return -1;

        String[] splitDate = date.split("\\.");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000 + Integer.parseInt(splitDate[2]));

        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date FirstDayOfYearDate = calendar.getTime();

        calendar.set(Calendar.MONTH, Integer.parseInt(splitDate[1]) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splitDate[0]));
        Date InputDate = calendar.getTime();

        long result = InputDate.getTime() - FirstDayOfYearDate.getTime();
        return TimeUnit.DAYS.convert(result, TimeUnit.MILLISECONDS);
    }

    public static long CalculateDaysFromYearsBeginning2(String date) {
        String dateFormatRegex = "^([0-2][0-9]|3[0-1])\\.(0[0-9]|1[0-2])\\.([0-9][0-9])?[0-9][0-9]$";
        if (!(date.matches(dateFormatRegex)))
            return -1;

        String[] splitDate = date.split("\\.");
        int inputDay = Integer.parseInt(splitDate[0]);
        Month inputMonth = Month.of(Integer.parseInt(splitDate[1]));
        int inputYear = 2000 + Integer.parseInt(splitDate[2]);

        LocalDateTime firstDayOfYearDate = LocalDateTime.of(inputYear, Month.of(1), 1, 0, 0);
        LocalDateTime inputDate = LocalDateTime.of(inputYear, inputMonth, inputDay, 0, 0);

        return ChronoUnit.DAYS.between(firstDayOfYearDate, inputDate);
    }

}
