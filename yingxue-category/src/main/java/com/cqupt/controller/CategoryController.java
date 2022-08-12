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
@RequestMapping("/categories")
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

    /**
     * 添加类别接口
     */
    @PostMapping()
    public Category save(@RequestBody Category category) {
        return categoryService.insert(category);
    }

    /**
     * 更新列表接口
     */
    @PatchMapping("/{id}")
    public Category update(@PathVariable("id") Integer id, @RequestBody Category category) {
        category.setId(id);
        return categoryService.update(category);
    }

    /**
     * 删除类别接口
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (categoryService.deleteById(id)) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}

