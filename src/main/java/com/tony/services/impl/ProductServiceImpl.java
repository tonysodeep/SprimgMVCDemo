/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tony.services.impl;

import com.tony.pojos.Product;
import com.tony.repositories.ProductRepository;
import com.tony.services.ProductSevice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hyngu
 */
@Service
public class ProductServiceImpl implements ProductSevice {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(String kw, int page) {
        return this.productRepository.getProducts(kw, page);
    }

    @Override
    public int countProducts() {
        return this.productRepository.countProducts();
    }

}
