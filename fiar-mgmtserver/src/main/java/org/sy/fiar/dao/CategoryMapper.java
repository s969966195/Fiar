package org.sy.fiar.dao;

import org.apache.ibatis.annotations.Param;
import org.sy.fiar.bean.Category;

import java.util.List;

/**
 * 分类Dao
 *
 * @author SY
 * @since 2021/7/7 23:27
 */
public interface CategoryMapper {

    List<Category> getAllCategories();

    int deleteCategoryByIds(@Param("ids") List<String> ids);

    int updateCategoryById(Category category);

    int addCategory(Category category);

    /**
     * 根据id查找分类
     *
     * @param id id
     * @return Category
     */
    Category getCategoryById(String id);
}
