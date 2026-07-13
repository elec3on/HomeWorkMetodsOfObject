public class Main {
    public static void main(String[] args) {

        Product product1 = new Product(101, "Смартфон X", 35000, "Электроника");
        Product product2 = new Product(101, "Смартфон X Pro", 40000, "Электроника"); // тот же артикул, та же категория
        Product product3 = new Product(102, "Наушники", 5000, "Аудио");
        Product product4 = new Product(101, "Смартфон X", 35000, null); // категория null

        System.out.println("=== Список товаров (Product) ===");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
        System.out.println(product4);
        System.out.printf("=================================================%n%n");

        System.out.println("=== Сравнение товаров ===");
        System.out.println("product1 equals product2? " + product1.equals(product2)); // true (id и category совпадают)
        System.out.println("product1 equals product3? " + product1.equals(product3)); // false (разные id/category)
        System.out.println("product1 equals product4? " + product1.equals(product4)); // false (category: "Электроника" vs null)
        System.out.printf("=================================================%n%n");

        System.out.println("=== Список заказов (Order) ===");

        Product[] basketA = {product1, product3};
        Product[] basketB = {product1, product3};           // точно такой же набор
        Product[] basketC = {product3, product1};           // другой порядок
        Product[] basketD = {product1};               // меньше товаров

        Order order1 = new Order("Анна", basketA);
        Order order2 = new Order("Анна", basketB);  // одинаковые поля и корзина
        Order order3 = new Order("Борис", basketA); // другой клиент
        Order order4 = new Order("Анна", basketC);  // та же корзина, но другой порядок
        Order order5 = new Order("Анна", basketD);  // другая корзина

        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
        System.out.println(order4);
        System.out.println(order5);
        System.out.printf("=================================================%n%n");

        System.out.println("=== Сравнение заказов ===");
        System.out.println("order1 equals order2? " + order1.equals(order2)); // true
        System.out.println("order1 equals order3? " + order1.equals(order3)); // false (другой клиент)
        System.out.println("order1 equals order4? " + order1.equals(order4)); // false (порядок товаров разный)
        System.out.println("order1 equals order5? " + order1.equals(order5)); // false (разный состав корзины)
    }
}