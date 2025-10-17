package main.java.lessons.lesson3;

import java.util.ArrayList;

public class OnlineStore {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product newProduct) {
        for (Product product : products) {
            if(product.code.equalsIgnoreCase(newProduct.code) && product.name.equalsIgnoreCase(newProduct.name)
                && product.price == newProduct.price) {
                product.count = product.count + newProduct.count;
                return;
            }
        }
        products.add(newProduct);
    }

    public void buyProduct(String name, int amount) {
        Product product = searchProduct(name);
            if(product != null) {
                if(product.count > 0 && product.count >= amount) {
                    product.count = product.count - amount;
                    if (product.count == 0) {
                        products.remove(product);
                    }
                    return;
                } else {
                    System.out.printf("Недостаточно количество товара %s\n", product.name);
                    return;
                }
            }
        System.out.printf("Товар %s не найден.\n", name);
    }

    public void getProductInfo(String name) {
        Product product = searchProduct(name);
            if(product != null) {
                product.GetProductInfo();
                return;
            }
        System.out.printf("Товар %s не найден.\n", name);
    }

    public void getProducts() {
        if (!products.isEmpty()) {
            for (Product product : products) {
                product.GetProductInfo();
            }
        } else System.out.println("Магазин пуст\n");
    }

    private Product searchProduct(String productName){
        return products.stream().filter(p -> p.name.equalsIgnoreCase(productName)).findFirst().orElse(null);
    }

    public class Product {
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
            System.out.printf("Код: %s, Название: %s, Цена: %d, Количество: %d\n", code, name, price, count);
        }
    }
}

