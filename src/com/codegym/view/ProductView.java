package com.codegym.view;

import com.codegym.controller.ProductController;
import com.codegym.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Chuong trinh quan ly san pham");
        ProductController productController = new ProductController();
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    List<Product> productList = productController.getProducts();
                    for (Product product : productList) {
                        System.out.println("ID: " + product.getId() + " NAME: " + product.getName() + " PRICE: " + product.getPrice());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Add Product.");
                    Product productObject = inputProduct();
                    productController.addProduct(productObject);
                    break;

                }
            }

        } while (choice != 0);
    }
    private static void menu() {
        System.out.println("1. Hien thi danh sach san pham.");
        System.out.println("2. Them moi san pham.");
        System.out.println("0. Thoat");
        System.out.println("Chon chuc nang:");
    }

    private static Product inputProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ID:");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Nhap NAME:");
        String name = input.nextLine();
        System.out.println("Nhap PRICE:");
        Double price = input.nextDouble();

        Product product = new Product(id, name, price);
        return product;
    }
}
