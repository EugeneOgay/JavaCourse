//package main.java.lessons.lesson3;
//
//import java.util.ArrayList;
//
//public class OnlineStore {
//    public static ArrayList<Product> products = new ArrayList<>();
//
//    public static void AddProduct(Product newProduct) {
//        for (Product product : products) {
//            if(product.name.equalsIgnoreCase(newProduct.name) && )
//        }
//        products.add(product);
//    }
//
//    public static void BuyProduct(String name, int amount) {
//        for (Product product : products) {
//            if(product.name.equalsIgnoreCase(name) && product.count > 0 && product.count > amount) {
//                product.count--;
//            }
//        }
//    }
//
//
//
//    public static class Product {
//        private String code;
//        private String name;
//        private int price;
//        private int count;
//
//        public Product(String code, String name, int price, int count) {
//            this.code = code;
//            this.name = name;
//            this.price = price;
//            this.count = count;
//        }
//
//        public String GetProductInfo() {
//            return String.format("Код: %s, Название: %s, Цена: %.d, Количество: %d",
//                code, name, price, count);
//        }
//
////        public String getCode() {
////            return code;
////        }
////
////        public int getCount() {
////            return count;
////        }
////
////        public void decreaseCount(int qty) {
////            this.count -= qty;
////        }
//    }
//
//
//    Метод: addProduct(), buyProduct(), getProductInfo(), getProducts()
//
//}
//
