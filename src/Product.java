import java.util.Objects;

public class Product {
    private int id;              // артикул
    private String name;          // название
    private int price;            // цена
    private String category;      // категория

    public Product(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Товар[артикул=" + id + ", название=" + name + ", цена=" + price + ", категория=" + category + "]";
    }

    @Override
    public boolean equals(Object o) {
        // Проверка на сравнение с самим собой
        if (this == o) return true;

        // Если o null или не Product — не равны
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        // Товары равны при совпадении id и category
        return this.id == product.id && Objects.equals(this.category, product.category);
    }
}
