package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.CategoryDTO;

import java.util.List;

public interface iCategoryService {
    CategoryDTO queryCategory(CategoryDTO category);
    List<CategoryDTO> queryAllCategories();

    int insertCategoryDTO(CategoryDTO category);
    int updateCategoryDTO(CategoryDTO category);
    int deleteCategoryDTO(CategoryDTO category);
}
