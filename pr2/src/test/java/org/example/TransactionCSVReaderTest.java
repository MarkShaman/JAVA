package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тест для TransactionCSVReader
 */
class TransactionCSVReaderTest {

    @Test
    void testReadTransactions(@TempDir Path tempDir) throws IOException {
        // 1. Створюємо тимчасовий CSV файл
        Path filePath = tempDir.resolve("test.csv");
        String csvContent = "Дата,Сума,Категорія\n" + // Заголовок
                "01-01-2023,1000,Зарплата\n" +
                "02-01-2023,-150,Кафе\n" +
                "03-01-2023,-2000,Оренда";
        Files.write(filePath, csvContent.getBytes("UTF-8"));

        // 2. Викликаємо метод, використовуючи URI файлу як URL
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath.toUri().toString());

        // 3. Перевіряємо результат
        assertEquals(3, transactions.size(), "Має прочитати 3 транзакції (не враховуючи заголовок)");
        assertEquals(1000.0, transactions.get(0).getAmount());
        assertEquals("Кафе", transactions.get(1).getDescription());
        assertEquals(-2000.0, transactions.get(2).getAmount());
    }
}