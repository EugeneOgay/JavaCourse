package main.java.lessons.lesson3;

import java.util.ArrayList;

public class OnlineStore {
    public static ArrayList<Product> products = new ArrayList<>();

    public static void AddProduct(Product newProduct) {
        if (!products.isEmpty()) {
            for (Product product : products) {
                if(product.code.equalsIgnoreCase(newProduct.code) && product.name.equalsIgnoreCase(newProduct.name)
                    && product.price == newProduct.price) {
                    product.count = product.count + newProduct.count;
                    return;
                }
            }
        }
        else products.add(newProduct);
    }

    public static void BuyProduct(String name, int amount) {
        for (Product product : products) {
            if(product.name.equalsIgnoreCase(name)) {
                if(product.count > 0 && product.count > amount) {
                    product.count--;
                    return;
                } else System.out.println("Недостаточно товара");
            }
        }
        System.out.printf("Товар %s не найден.", name);
    }

    public static void GetProductInfo(String name) {
        for (Product product : products) {
            if(product.name.equalsIgnoreCase(name)) {
                product.GetProductInfo();
                return;
            }
        }
        System.out.printf("Товар %s не найден.", name);
    }

    public static void GetProducts() {
        if (!products.isEmpty()) {
            for (Product product : products) {
                product.GetProductInfo();
            }
        } else System.out.println("Магазин пуст");
    }

    public static class Product {
        private String code;
        private String name;
        private int price;
        private int count;

        public Product(String code, String name, int price, int count) {
            this.code = code;
            this.name = name;
            this.price = price;
            this.count = count;
        }

        public void GetProductInfo() {
            System.out.printf("Код: %s, Название: %s, Цена: %d, Количество: %d", code, name, price, count);
        }
    }
}

