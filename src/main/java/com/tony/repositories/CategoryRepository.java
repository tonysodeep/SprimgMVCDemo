/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tony.repositories;

import com.tony.pojos.Category;
import java.util.List;

/**
 *
 * @author hyngu
 */
public interface CategoryRepository {
    List<Category> getCategories();
}
