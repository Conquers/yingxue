package com.cqupt.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 分类(Category)实体类
 *
 * @author makejava
 * @since 2022-08-11 20:14:20
 */
@JsonInclude(JsonInclude.Include.NON_NULL) //只要json中不为空的数据
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 561201613439589196L;
    
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 父级分类id
     */
    private Integer parentId;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private Date deletedAt;

}

