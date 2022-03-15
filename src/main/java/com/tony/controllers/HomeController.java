/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tony.controllers;

import com.tony.services.CategoryService;
import com.tony.services.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hyngu
 */
@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductSevice productSevice;

    @RequestMapping("/")
    public String index(Model model,
            @RequestParam(name = "kw", required = false) String kw,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("products", this.productSevice.getProducts(kw, page));
        model.addAttribute("productCounter", this.productSevice.countProducts());
        System.out.println("kw" + kw);
        return "index";
    }

}
