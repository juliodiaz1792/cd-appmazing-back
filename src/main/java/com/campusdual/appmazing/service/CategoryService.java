package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.iCategoryService;
import com.campusdual.appmazing.api.iContactService;
import com.campusdual.appmazing.model.Category;
import com.campusdual.appmazing.model.dao.CategoryDAO;
import com.campusdual.appmazing.model.dao.ContactDAO;
import com.campusdual.appmazing.model.dto.CategoryDTO;
import com.campusdual.appmazing.model.dto.dtomapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryService")
@Lazy
public class CategoryService implements iCategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public CategoryDTO queryCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDTO);
        Category categoryFinal = this.categoryDAO.getReferenceById(category.getId());
        return CategoryMapper.INSTANCE.toDTO(categoryFinal);
    }

    @Override
    public List<CategoryDTO> queryAllCategories() {
        return CategoryMapper.INSTANCE.toDTOList(this.categoryDAO.findAll());
    }

    @Override
    public int insertCategoryDTO(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDTO);
        Category category1 = this.categoryDAO.saveAndFlush(category);
        return category1.getId();
    }

    @Override
    public int updateCategoryDTO(CategoryDTO categoryDTO) {
        return this.insertCategoryDTO(categoryDTO);
    }

    @Override
    public int deleteCategoryDTO(CategoryDTO categoryDTO) {
        int id = categoryDTO.getId();
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDTO);
        this.categoryDAO.delete(category);
        return id;
    }
}
