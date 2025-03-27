package org.example.model;

public class Store {
    public static void listProducts(ProductForSale[] products) {
        for (ProductForSale product : products) {
            product.showDetails();
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        ProductForSale[] products = {
                new Chocolate(2.5, "Delicious dark chocolate", 70),
                new Coke(1.5, "Refreshing cola drink", false),
                new Bread(1.0, "Whole wheat bread", "Whole Wheat")
        };

        listProducts(products);
    }
}
