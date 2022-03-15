/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tony.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tony.pojos.Product;
import com.tony.repositories.ProductRepository;
import com.tony.services.ProductSevice;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Product> getProducts(String kw, int page) {
        return this.productRepository.getProducts(kw, page);
    }
    
    @Override
    public int countProducts() {
        return this.productRepository.countProducts();
    }
    
    @Override
    public boolean addOrUpdateProduct(Product p) {
        if (p.getFile() != null) {
            try {
                Map res = this.cloudinary.uploader().upload(p.
                        getFile().
                        getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                p.setImage((String) res.get("secure_url"));
            } catch (IOException ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return this.productRepository.addOrUpdateProduct(p);
    }
    
}
