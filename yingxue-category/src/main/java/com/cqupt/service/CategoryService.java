package com.cqupt.service;

import com.cqupt.entity.Category;

import java.util.List;

/**
 * 分类(Category)表服务接口
 *
 * @author makejava
 * @since 2022-08-11 20:14:20
 */
public interface CategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Category queryById(Integer id);


    /**
     * 新增数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    Category insert(Category category);

    /**
     * 修改数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    Category update(Category category);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 类别列表
     * @return
     */
    List<Category> queryByFirstLevel();
}
