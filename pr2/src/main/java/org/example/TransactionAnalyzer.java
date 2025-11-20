package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class TransactionAnalyzer {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // --- Базові методи з презентації ---

    public static double calculateTotalBalance(List<Transaction> transactions) {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
        int count = 0;
        for (Transaction t : transactions) {
            LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMATTER);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    public static List<Transaction> findTopExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Тільки витрати
                .sorted(Comparator.comparing(Transaction::getAmount)) // Сортуємо від найменшого (-1000 менше ніж -10)
                .limit(10)
                .collect(Collectors.toList());
    }

    // --- Методи для самостійної роботи ---

    // Пошук найбільшої витрати за період (найбільша від'ємна сума, тобто min arithmetic value)
    public static Transaction findMaxExpenseInPeriod(List<Transaction> transactions, String startStr, String endStr) {
        LocalDate start = LocalDate.parse(startStr, DATE_FORMATTER);
        LocalDate end = LocalDate.parse(endStr, DATE_FORMATTER);

        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .filter(t -> {
                    LocalDate d = LocalDate.parse(t.getDate(), DATE_FORMATTER);
                    return !d.isBefore(start) && !d.isAfter(end);
                })
                .min(Comparator.comparing(Transaction::getAmount))
                .orElse(null);
    }

    // Групування витрат по категоріях
    public static Map<String, Double> getExpensesByCategory(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .collect(Collectors.groupingBy(
                        Transaction::getDescription,
                        Collectors.summingDouble(Transaction::getAmount)
                ));
    }
}