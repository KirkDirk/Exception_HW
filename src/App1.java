import java.util.NoSuchElementException;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) throws Exception {
        // // Семинар 1. Задание 1.
        // // ArithmeticException
        // // NumberFormatException
        // // NoSuchElementException
        // int divisible = prompt("Введите значение делимого: ");
        // int divider = prompt("Введите значение делителя: ");
        //System.out.println("Результат деления: " + division(divisible, divider));

        // // Семинар 1. Задание 2.
        // int[] array1 = {7,7,2,37,5,0,-1,19,0};
        // int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        // try {
        //     int [] array3 = arrayDiff(array1, array2);
        //     System.out.println("Итоговый массив: ");
        //     for (int i = 0; i < array3.length; i++) {
        //         System.out.print(array3[i]+ " ");    
        //         } 
        //     }
        // catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Вычисление массива прервано: исходные массивы разной длины");
        // }
        
        // // Семинар 1. Задание 3.
        // int[] array1 = {7,7,2,37,5,0,-1,19,0,13};
        // int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        // try {
        //     double [] array3 = arrayDiv(array1, array2);
        //     System.out.println("Итоговый массив: ");
        //     for (int i = 0; i < array3.length; i++) {
        //         System.out.print(array3[i]+ " ");    
        //         } 
        //     }
        // catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Вычисление массива прервано: исходные массивы разной длины");
        // }
        // catch (ArithmeticException e) {
        //     System.out.println("Вычисление массива прервано: происходит деление на 0");
        // }

        // // Семинар 2. Задание 1.
        // System.out.println("Введено число: " + getFloat());

        // Семинар 2. Задание 2.
        int[] intArray = {1,2,3,4,5,6,7,8,9};
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (ArithmeticException|ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
         } finally {
            System.out.println("Завершено");
         }
         
    }

    /**
     * Семинар 1. Задание 1. Метод деления двух чисел. 
     * ArithmeticException - деление на 0 - 
     * @param number1
     * @param number2
     * @return
     */
    static int division(int number1, int number2) {
        if (number2 == 0) {
            throw new RuntimeException("На 0 делить нельзя");
        }
        return number1 / number2;
    }

    /**
     * Семинар 1. Задание 1. Метод ввода данных с клавиатуры. 
     * NumberFormatException - ввод строковых вместо цифр, 
     * NoSuchElementException - отсуствие введенных данных
     * @param message
     * @return
     */
    static int prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        String prompt = in.nextLine();
        if (prompt == "") {
            throw new RuntimeException("Значение не введено");
        }
        int promptInt = 0;
        try {
            promptInt = Integer.parseInt(prompt);
        } catch (NumberFormatException e) {
            System.out.println("Введено не число");
        }
        return promptInt;
    }

    /**
     * Семинар 1. Задание 2. Метод разности двух массивов
     * @param arr1
     * @param arr2
     * @return
     */
    static int[] arrayDiff(int[] arr1, int[] arr2) {
        int length = Math.max(arr1.length, arr2.length); // чтобы охватить все варианты разных длин массивов,
        // когда первый массив может быть длиннее, и наоборот, когда длиннее второй
        int[] arr3 = new int[length];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = arr1[i] - arr2[i];
        }
        return arr3;
    }

    /**
     * Семинар 1. Задание 2. Метод деления двух массивов
     * @param arr1
     * @param arr2
     * @return
     */
    static double[] arrayDiv(int[] arr1, int[] arr2){
        int length = Math.max(arr1.length, arr2.length); // чтобы охватить все варианты разных длин массивов,
        // когда первый массив может быть длиннее, и наоборот, когда длиннее второй
        double[] arr3 = new double[length];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (double) arr1[i] / arr2[i];
        }
        return arr3;
    }

    /**
     * Семинар 2. Задание 1. Метод ввода дробного числа.
     * @return
     */
    static float getFloat () {
        float flNum = 0;
        boolean getFloat = true;
        Scanner in = new Scanner(System.in);
        while (getFloat) {            
            System.out.println("Введите дробное число: ");
            try {
                flNum = Float.parseFloat(in.nextLine());
                getFloat = false;
            } catch (NumberFormatException|NoSuchElementException e) {
                System.out.println("Введены неверные данные. Повторите ввод");
            }            
        }
        in.close();
        return flNum;
    }
}
