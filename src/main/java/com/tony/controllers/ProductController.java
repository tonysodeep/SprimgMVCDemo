/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tony.controllers;

import com.tony.pojos.Product;
import com.tony.services.CategoryService;
import com.tony.services.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hyngu
 */
@Controller
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    private ProductSevice productSevice;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/product-add")
    public String addView(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/product-add")
    public String addHandeler(Model model,
            @ModelAttribute(value = "product") Product p) {
        if (this.productSevice.addOrUpdateProduct(p) == true) {
            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Something wrong");
        }

        return "product";
    }

}
