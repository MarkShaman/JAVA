import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Категорії
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Товари
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        Cart cart = new Cart();
        OrderHistory history = new OrderHistory();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Видалити товар з кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Переглянути історію замовлень");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання:");
                    int idAdd = scanner.nextInt();
                    if (idAdd == 1) cart.addProduct(product1);
                    else if (idAdd == 2) cart.addProduct(product2);
                    else if (idAdd == 3) cart.addProduct(product3);
                    else System.out.println("Товар не знайдено");
                    break;
                case 3:
                    System.out.println("Введіть ID товару для видалення:");
                    int idRemove = scanner.nextInt();
                    if (idRemove == 1) cart.removeProduct(product1);
                    else if (idRemove == 2) cart.removeProduct(product2);
                    else if (idRemove == 3) cart.removeProduct(product3);
                    else System.out.println("Товар не знайдено у кошику");
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній!");
                    } else {
                        Order order = new Order(cart);
                        history.addOrder(order); // збереження в історію
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;
                case 6:
                    System.out.println(history);
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція.");
            }
        }
    }
}
