import java.util.Arrays;
import java.util.Objects;

public class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket;
    }

    public String getCustomer() {
        return customer;
    }

    public Product[] getBasket() {
        return basket;
    }

    @Override
    public String toString() {
        return "Заказ[клиент=" + customer + ", корзина=" + Arrays.toString(basket) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        if (!Objects.equals(customer, order.customer)) return false;
        if (basket.length != order.basket.length) return false;
        for (int i = 0; i < basket.length; i++) {
            if (!Objects.equals(basket[i], order.basket[i])) {
                return false;
            }
        }
        return true;
    }
}