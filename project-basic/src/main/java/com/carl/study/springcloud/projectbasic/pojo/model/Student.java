package com.carl.study.springcloud.projectbasic.pojo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author changez
 * @desc
 * @datetime 2019/8/12 12:33
 */
@Data
@Accessors(chain = true)
public class Student {
    private Long id;
    private String name;
    private String password;
    private String ip;
}
