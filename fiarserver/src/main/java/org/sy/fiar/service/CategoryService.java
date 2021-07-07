package org.sy.fiar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.sy.fiar.bean.Category;
import org.sy.fiar.mapper.CategoryMapper;

import java.sql.Timestamp;
import java.util.List;

/**
 * description
 *
 * @author SY
 * @since 2021/7/7 23:26
 */
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    public boolean deleteCategoryByIds(String ids) {
        String[] split = ids.split(",");
        int result = categoryMapper.deleteCategoryByIds(split);
        return result == split.length;
    }

    public int updateCategoryById(Category category) {
        return categoryMapper.updateCategoryById(category);
    }

    public int addCategory(Category category) {
        category.setDate(new Timestamp(System.currentTimeMillis()));
        return categoryMapper.addCategory(category);
    }

}
