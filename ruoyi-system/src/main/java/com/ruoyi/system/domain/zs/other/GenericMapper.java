package com.ruoyi.system.domain.zs.other;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/2/24 17:01
 */
public interface GenericMapper<T extends GenericModel, ID> {
    T findById(ID var1);

    int save(T var1);

    int deleteById(ID var1);

    int updateById(T var1);
}
