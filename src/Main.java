import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Категорії
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");


        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);


        Product[] products = {product1, product2, product3};

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
            System.out.println("7 - Пошук товарів");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очищення буфера після nextInt()

            switch (choice) {
                case 1:
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання:");
                    int idAdd = scanner.nextInt();
                    if (idAdd >= 1 && idAdd <= products.length) {
                        cart.addProduct(products[idAdd - 1]);
                    } else {
                        System.out.println("Товар не знайдено");
                    }
                    break;
                case 3:
                    System.out.println("Введіть ID товару для видалення:");
                    int idRemove = scanner.nextInt();
                    if (idRemove >= 1 && idRemove <= products.length) {
                        cart.removeProduct(products[idRemove - 1]);
                    } else {
                        System.out.println("Товар не знайдено у кошику");
                    }
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній!");
                    } else {
                        Order order = new Order(cart);
                        history.addOrder(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;
                case 6:
                    System.out.println(history);
                    break;
                case 7:
                    System.out.println("Оберіть варіант пошуку:");
                    System.out.println("1 - За назвою");
                    System.out.println("2 - За категорією");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine(); // очищення буфера

                    if (searchChoice == 1) {
                        System.out.println("Введіть назву товару:");
                        String nameSearch = scanner.nextLine().toLowerCase();
                        boolean found = false;
                        for (Product p : products) {
                            if (p.getName().toLowerCase().contains(nameSearch)) {
                                System.out.println(p);
                                found = true;
                            }
                        }
                        if (!found) System.out.println("Товарів не знайдено.");
                    } else if (searchChoice == 2) {
                        System.out.println("Введіть назву категорії:");
                        String categorySearch = scanner.nextLine().toLowerCase();
                        boolean found = false;
                        for (Product p : products) {
                            if (p.getCategory().getName().toLowerCase().contains(categorySearch)) {
                                System.out.println(p);
                                found = true;
                            }
                        }
                        if (!found) System.out.println("Товарів не знайдено.");
                    } else {
                        System.out.println("Невірний вибір.");
                    }
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

