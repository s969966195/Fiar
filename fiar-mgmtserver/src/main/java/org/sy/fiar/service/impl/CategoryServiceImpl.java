package org.sy.fiar.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sy.fiar.bean.Category;
import org.sy.fiar.bean.req.PageReq;
import org.sy.fiar.dao.CategoryMapper;
import org.sy.fiar.service.CategoryService;

import java.util.List;

/**
 * description
 *
 * @author SY
 * @since 2022/8/10 23:32
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryPage(PageReq pageReq) {
        int pageNum = pageReq.getPageNum();
        int pageSize = pageReq.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return categoryMapper.getAllCategories();
    }

    @Override
    public int saveCategory(Category category) {
        return categoryMapper.addCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategoryById(category);
    }

    @Override
    public void deleteCategory(List<String> categoryIds) {
        categoryMapper.deleteCategoryByIds(categoryIds);
    }

    @Override
    public Category findCategoryById(String categoryId) {
        return categoryMapper.getCategoryById(categoryId);
    }
}
