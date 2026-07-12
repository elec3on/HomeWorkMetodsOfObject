import java.util.Arrays;
import java.util.Objects;

public class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        // Копируем массив, чтобы нельзя было изменить корзину снаружи
        this.basket = basket != null ? Arrays.copyOf(basket, basket.length) : null;
    }

    public String getCustomer() {
        return customer;
    }

    public Product[] getBasket() {
        // Возвращаем копию, чтобы не менять корзину снаружи
        return basket != null ? Arrays.copyOf(basket, basket.length) : null;
    }

    @Override
    public String toString() {
        return "Заказ[клиент=" + customer + ", корзина=" + Arrays.toString(basket) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order other = (Order) o;

        // Сравнение строк с учётом null
        if (!Objects.equals(this.customer, other.customer)) return false;

        // Сравнение корзин (массивов товаров)
        if (this.basket == null && other.basket == null) return true;
        if (this.basket == null || other.basket == null) return false;
        if (this.basket.length != other.basket.length) return false;

        // Поэлементное сравнение товаров через их equals()
        for (int i = 0; i < this.basket.length; i++) {
            Product p1 = this.basket[i];
            Product p2 = other.basket[i];

            // Если хотя бы один из товаров null — не равны (или можно сделать иначе, но так безопаснее)
            if (p1 == null || p2 == null) {
                if (p1 != p2) return false; // один null, другой не null
                continue;
            }

            if (!p1.equals(p2)) return false;
        }

        return true;
    }
}