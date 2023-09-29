package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.iCategoryService;
import com.campusdual.appmazing.model.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private iCategoryService categoryService;

    @GetMapping("/test")
    public String testController() {
        return "Category controller works!";
    }

    @PostMapping("/get")
    public CategoryDTO queryCategory(@RequestBody CategoryDTO category) {
        return this.categoryService.queryCategory(category);
    }

    @GetMapping("/getAll")
    public List<CategoryDTO> queryAllCategory() {
        return this.categoryService.queryAllCategories();
    }

    @PostMapping("/add")
    public int insertCategory(@RequestBody CategoryDTO category) {
        return this.categoryService.insertCategoryDTO(category);
    }

    @PutMapping("/put")
    public int putCategory(@RequestBody CategoryDTO category) {
        return this.categoryService.updateCategoryDTO(category);
    }

    @DeleteMapping("/delete")
    public int deleteCategory(@RequestBody CategoryDTO category) {
        return this.categoryService.deleteCategoryDTO(category);
    }
}
