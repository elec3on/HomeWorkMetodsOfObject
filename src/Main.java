public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование Product ===");

        Product p1 = new Product(101, "Смартфон X", 35000, "Электроника");
        Product p2 = new Product(101, "Смартфон X Pro", 40000, "Электроника"); // тот же артикул, та же категория
        Product p3 = new Product(102, "Наушники", 5000, "Аудио");
        Product p4 = new Product(101, "Смартфон X", 35000, null); // категория null

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        System.out.println("p1 equals p2? " + p1.equals(p2)); // true (id и category совпадают)
        System.out.println("p1 equals p3? " + p1.equals(p3)); // false (разные id/category)
        System.out.println("p1 equals p4? " + p1.equals(p4)); // false (category: "Электроника" vs null)

        System.out.println("\n=== Тестирование Order ===");

        Product[] basketA = {p1, p3};
        Product[] basketB = {p1, p3};           // точно такой же набор
        Product[] basketC = {p3, p1};           // другой порядок
        Product[] basketD = {p1};               // меньше товаров

        Order o1 = new Order("Анна", basketA);
        Order o2 = new Order("Анна", basketB);  // одинаковые поля и корзина
        Order o3 = new Order("Борис", basketA); // другой клиент
        Order o4 = new Order("Анна", basketC);  // та же корзина, но другой порядок
        Order o5 = new Order("Анна", basketD);  // другая корзина

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println(o4);
        System.out.println(o5);

        System.out.println("o1 equals o2? " + o1.equals(o2)); // true
        System.out.println("o1 equals o3? " + o1.equals(o3)); // false (другой клиент)
        System.out.println("o1 equals o4? " + o1.equals(o4)); // false (порядок товаров разный)
        System.out.println("o1 equals o5? " + o1.equals(o5)); // false (разный состав корзины)
    }
}