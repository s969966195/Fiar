package org.sy.fiar.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sy.fiar.bean.Category;
import org.sy.fiar.dao.CategoryMapper;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 * 分类管理
 *
 * @author SY
 * @since 2021/7/7 23:26
 */
@Service
@Transactional
public class CategoryManagerService {

    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    public boolean deleteCategoryByIds(String ids) {
        List<String> split = Arrays.asList(ids.split(","));
        int result = categoryMapper.deleteCategoryByIds(split);
        return result == split.size();
    }

    public int updateCategoryById(Category category) {
        return categoryMapper.updateCategoryById(category);
    }

    public int addCategory(Category category) {
        category.setDate(new Timestamp(System.currentTimeMillis()));
        return categoryMapper.addCategory(category);
    }
}
