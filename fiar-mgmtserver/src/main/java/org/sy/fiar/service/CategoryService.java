package org.sy.fiar.service;

import org.sy.fiar.bean.Category;
import org.sy.fiar.bean.req.PageReq;

import java.util.List;

/**
 * 分类
 *
 * @author SY
 * @since 2022/8/10 23:01
 */
public interface CategoryService {

    /**
     * 获取所有的分类（分页）
     *
     * @return list
     */
    List<Category> getCategoryPage(PageReq pageReq);

    /**
     * 新建分类
     *
     * @param category categoryId
     * @return int
     */
    int saveCategory(Category category);

    /**
     * 修改分类
     *
     * @param category categoryId
     * @return int
     */
    int updateCategory(Category category);

    /**
     * 删除分类
     *
     * @param categoryIds categoryIds
     */
    void deleteCategory(List<String> categoryIds);

    /**
     * 根据分类id查找分类
     *
     * @param categoryId categoryId
     * @return Category
     */
    Category findCategoryById(String categoryId);
}
