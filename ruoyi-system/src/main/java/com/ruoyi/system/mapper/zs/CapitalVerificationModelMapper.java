package com.ruoyi.system.mapper.zs;
import com.ruoyi.system.domain.zs.CapitalVerificationModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *capital_verification dao
 */
@Mapper
public interface CapitalVerificationModelMapper {

    CapitalVerificationModel findById(Integer id);

    int save(CapitalVerificationModel model);

    int deleteById(Integer id);

    int updateById(CapitalVerificationModel var1);

    List<CapitalVerificationModel> findALL();

    Long deleteByIds(@Param("ids") List<Integer> ids);

    List<CapitalVerificationModel> selectActiveList(CapitalVerificationModel model);

    Integer findMaxId();
}
