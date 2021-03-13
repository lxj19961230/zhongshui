package com.ruoyi.system.mapper.zs;

import com.ruoyi.system.domain.zs.CodeRule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/3/12 10:17
 */
@Mapper
public interface CodeRuleMapper {

    public Integer save(CodeRule data);

    public List<CodeRule> getAllDataForUpdateByTypeAndYear(@Param("year") Integer year, @Param("type")Integer type);

    public Integer updateActiveAndBizId(@Param("type")Integer type, @Param("year")Integer year, @Param("sequence")Integer sequence,@Param("bizId")Integer bizId);

    public Integer updateActiveByBizId(@Param("type")Integer type, @Param("bizId")Integer bizId);

    public Integer updateDisActiveByBizId(@Param("type")Integer type, @Param("bizId")Integer bizId);

}
