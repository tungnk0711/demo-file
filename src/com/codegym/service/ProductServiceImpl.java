package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAllHaveBusiness() {

        // Xu li business logic
        // ....
        /// ....
        return productRepository.findAll();
    }

    @Override
    public void addHaveBusiness(Product product) {
        // Xu li business logic
        // ....
        //....
        productRepository.add(product);
    }
}
