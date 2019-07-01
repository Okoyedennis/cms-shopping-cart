package com.vojislavk.cmsshoppingcart.controllers;

import java.util.List;

import com.vojislavk.cmsshoppingcart.models.CategoryRepository;
import com.vojislavk.cmsshoppingcart.models.ProductRepository;
import com.vojislavk.cmsshoppingcart.models.data.Category;
import com.vojislavk.cmsshoppingcart.models.data.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/products")
public class AdminProductsController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping
    public String index(Model model) {
        
        List<Product> products = productRepo.findAll();

        model.addAttribute("products", products);

        return "admin/products/index";
    }

    @GetMapping("/add")
    public String add(Product product, Model model) {
        
        List<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);

        return "admin/products/add";
    }

    
}