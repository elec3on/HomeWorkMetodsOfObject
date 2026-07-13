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
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;

        // Сравнение строк с учётом null
        if (!Objects.equals(this.customer, order.customer)) return false;

        // Сравнение корзин (массивов товаров)
        if (this.basket == null && order.basket == null) return true;
        if (this.basket == null || order.basket == null) return false;
        if (this.basket.length != order.basket.length) return false;

        // Поэлементное сравнение товаров через их equals()
        for (int i = 0; i < this.basket.length; i++) {
            Product product1 = this.basket[i];
            Product product2 = order.basket[i];

            // Если хотя бы один из товаров null — не равны
            if (product1 == null || product2 == null) {
                if (product1 != product2) return false; // один null, другой не null
                continue;
            }

            if (!product1.equals(product2)) return false;
        }

        return true;
    }
}