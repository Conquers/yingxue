package com.cqupt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kioo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    /**
     * 用户名
     */
    @JsonProperty("name")
    private String username;
    /**
     * 用户头像地址
     */
    private String avatar;
}


