import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders;

    public OrderHistory() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public String toString() {
        if (orders.isEmpty()) {
            return "Історія замовлень порожня.";
        }
        StringBuilder sb = new StringBuilder("Історія замовлень:\n");
        int count = 1;
        for (Order order : orders) {
            sb.append("Замовлення №").append(count++).append("\n");
            sb.append(order).append("\n\n");
        }
        return sb.toString();
    }
}
