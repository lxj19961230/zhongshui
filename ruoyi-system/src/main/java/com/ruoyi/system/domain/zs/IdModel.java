package com.ruoyi.system.domain.zs;

import com.ruoyi.system.mapper.zs.GenericModel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/2/24 16:58
 */
@Data
public class IdModel extends GenericModel<Integer> {

    //主键id
    private Integer id;

    //主键id
    private LocalDateTime updateTime;

    //主键id
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
