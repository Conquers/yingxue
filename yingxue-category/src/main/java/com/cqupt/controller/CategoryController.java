package com.cqupt.controller;

import com.cqupt.entity.Category;
import com.cqupt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类(Category)表控制层
 *
 * @author makejava
 * @since 2022-08-11 20:14:20
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<Category> categories() {
        return categoryService.queryByFirstLevel();
    }
}

