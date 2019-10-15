package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;

import java.util.List;

public class ProductController {

    ProductService productService = new ProductServiceImpl();

    public List<Product> getProducts() {
        List<Product> productList = productService.findAllHaveBusiness();
        if(productList.size()<=0){
            System.out.println("Khong co san pham nao");
        }
        return productList;
    }

    public void addProduct(Product product) {
        productService.addHaveBusiness(product);
    }
}
