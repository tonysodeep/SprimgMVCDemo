/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tony.repositories;

import com.tony.pojos.Product;
import java.util.List;

/**
 *
 * @author hyngu
 */
public interface ProductRepository {

    List<Product> getProducts(String kw, int page);
    int countProducts();
    boolean addOrUpdateProduct(Product p);
    
}
