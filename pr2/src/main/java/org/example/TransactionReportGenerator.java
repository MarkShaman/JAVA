package org.example;

import java.util.List;
import java.util.Map;

public abstract class TransactionReportGenerator {

    public static void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 найбільших витрат:");
        for (Transaction t : topExpenses) {
            System.out.println(t.getDescription() + ": " + t.getAmount());
        }
    }

    // --- Метод для самостійної роботи (Текстова гістограма) ---
    public static void printExpenseReportVisual(Map<String, Double> expensesByCategory) {
        System.out.println("\n--- Візуальний звіт по витратах ---");
        for (Map.Entry<String, Double> entry : expensesByCategory.entrySet()) {
            String category = entry.getKey();
            double amount = entry.getValue(); // Це від'ємне число

            // Логіка для зірочок: 1 зірочка = 1000 одиниць (приблизно)
            // Math.abs щоб прибрати мінус, ділимо на 1000 для масштабу
            int starsCount = (int) (Math.abs(amount) / 1000);
            String stars = "*".repeat(Math.max(0, starsCount));

            System.out.printf("%-20s: %s (%.0f)\n", category, stars, amount);
        }
    }
}