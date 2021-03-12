package com.ruoyi.system.domain.zs;

import lombok.Data;

import java.io.Serializable;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/3/12 10:16
 */
@Data
public class CodeRule implements Serializable {

    private Integer sequence;

    private Integer year;

    private Integer type;

    //0有效1失效
    private Integer active;
}
