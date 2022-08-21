package org.sy.fiar.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sy.fiar.bean.Category;
import org.sy.fiar.bean.RespBean;
import org.sy.fiar.pub.annotation.OperationLogSys;
import org.sy.fiar.pub.annotation.OperationType;
import org.sy.fiar.service.admin.CategoryManagerService;

import java.util.List;

/**
 * 超级管理员
 *
 * @author SY
 * @since 2021/7/7 23:25
 */
@RestController
@RequestMapping("/admin/category")
public class CategoryManagerController {

    @Autowired CategoryManagerService categoryManagerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryManagerService.getAllCategories();
    }

    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteById(@PathVariable String ids) {
        boolean result = categoryManagerService.deleteCategoryByIds(ids);
        if (result) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @OperationLogSys(desc = "添加分类", operationType = OperationType.INSERT)
    public RespBean addNewCate(Category category) {

        if ("".equals(category.getCateName()) || category.getCateName() == null) {
            return new RespBean("error", "请输入栏目名称!");
        }

        int result = categoryManagerService.addCategory(category);

        if (result == 1) {
            return new RespBean("success", "添加成功!");
        }
        return new RespBean("error", "添加失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateCate(Category category) {
        int i = categoryManagerService.updateCategoryById(category);
        if (i == 1) {
            return new RespBean("success", "修改成功!");
        }
        return new RespBean("error", "修改失败!");
    }
}
