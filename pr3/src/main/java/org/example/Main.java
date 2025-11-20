package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("--- Калькулятор ---");

        try {
            // 1. Введення першого числа
            System.out.print("Введіть перше число: ");
            double num1 = scanner.nextDouble();

            // 2. Введення операції
            System.out.print("Введіть операцію (+, -, *, /, sqrt): ");
            String op = scanner.next();

            double result = 0;

            // 3. Вибір дії
            switch (op) {
                case "+":
                    System.out.print("Введіть друге число: ");
                    result = calculator.add(num1, scanner.nextDouble());
                    break;
                case "-":
                    System.out.print("Введіть друге число: ");
                    result = calculator.subtract(num1, scanner.nextDouble());
                    break;
                case "*":
                    System.out.print("Введіть друге число: ");
                    result = calculator.multiply(num1, scanner.nextDouble());
                    break;
                case "/":
                    System.out.print("Введіть друге число: ");
                    result = calculator.divide(num1, scanner.nextDouble());
                    break;
                case "sqrt":
                    result = calculator.sqrt(num1);
                    break;
                default:
                    throw new InvalidInputException("Невідома операція: " + op);
            }

            System.out.println("Результат: " + result);

        } catch (ArithmeticException e) {
            System.err.println("Помилка математики: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.err.println("Помилка даних: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Помилка введення: Ви ввели букви замість цифр.");
        } finally {
            System.err.println("Робота завершена.");
        }
    }
}