package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String url = "https://informer.com.ua/dut/java/pr2.csv";

        // 1. Отримання даних
        List<Transaction> transactions = TransactionCSVReader.readTransactions(url);

        // 2. Аналіз балансу
        double balance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(balance);

        // 3. Підрахунок транзакцій за січень 2024
        String month = "01-2024";
        int count = TransactionAnalyzer.countTransactionsByMonth(transactions, month);
        TransactionReportGenerator.printTransactionsCountByMonth(month, count);

        // 4. Топ витрат
        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);

        // --- Самостійна робота ---
        // 5. Візуальний звіт (зірочки)
        Map<String, Double> expensesByCategory = TransactionAnalyzer.getExpensesByCategory(transactions);
        TransactionReportGenerator.printExpenseReportVisual(expensesByCategory);
    }
}