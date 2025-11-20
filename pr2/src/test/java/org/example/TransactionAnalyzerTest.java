package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class TransactionAnalyzerTest {

    // Тест з презентації (Задача 2.2) [cite: 411]
    @Test
    public void testCalculateTotalBalance() { // [cite: 413]
        // Створення тестових даних [cite: 414]
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2023-01-01", 100.0, "Дохід"), // [cite: 415]
                new Transaction("2023-01-02", -50.0, "Витрата"), // [cite: 416]
                new Transaction("2023-01-03", 150.0, "Дохід") // [cite: 417]
        );

        // Виклик статичного методу [cite: 421]
        double result = TransactionAnalyzer.calculateTotalBalance(transactions); // [cite: 422]

        // Перевірка результату [cite: 423]
        Assertions.assertEquals(200.0, result, "Розрахунок загального балансу неправильний"); // [cite: 424]
    }

    // Тест з презентації (Задача 3.2) [cite: 478]
    @Test
    public void testCountTransactionsByMonth() { // [cite: 480]
        // Підготовка тестових даних [cite: 481, 494]
        List<Transaction> transactions = Arrays.asList(
                new Transaction("01-02-2023", 50.0, "Дохід"), // [cite: 482]
                new Transaction("15-02-2023", -20.0, "Витрата"), // [cite: 483]
                new Transaction("05-03-2023", 100.0, "Дохід") // [cite: 484]
        );

        // Виклик статичних методів [cite: 496]
        int countFeb = TransactionAnalyzer.countTransactionsByMonth(transactions, "02-2023"); // [cite: 488]
        int countMar = TransactionAnalyzer.countTransactionsByMonth(transactions, "03-2023"); // [cite: 489]

        // Перевірка результатів [cite: 497]
        Assertions.assertEquals(2, countFeb, "Кількість транзакцій за лютий неправильна"); // [cite: 491]
        Assertions.assertEquals(1, countMar, "Кількість транзакцій за березень неправильна"); // [cite: 492]
    }

    // Тест для самостійної роботи (Інструкція 5) [cite: 569]
    @Test
    public void testFindTopExpenses() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("01-01-2023", -100.0, "Кава"),
                new Transaction("02-01-2023", 500.0, "Зарплата"),
                new Transaction("03-01-2023", -500.0, "Оренда"),
                new Transaction("04-01-2023", -50.0, "Обід"),
                new Transaction("05-01-2023", -1000.0, "Подарунок")
        );

        // Виклик статичного методу
        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);

        // Перевірка
        Assertions.assertEquals(4, topExpenses.size(), "Має бути 4 витрати");
        // Перевірка сортування: від найбільшої (-1000) до найменшої (-50)
        Assertions.assertEquals(-1000.0, topExpenses.get(0).getAmount());
        Assertions.assertEquals(-500.0, topExpenses.get(1).getAmount());
        Assertions.assertEquals(-100.0, topExpenses.get(2).getAmount());
        Assertions.assertEquals(-50.0, topExpenses.get(3).getAmount());
    }
}