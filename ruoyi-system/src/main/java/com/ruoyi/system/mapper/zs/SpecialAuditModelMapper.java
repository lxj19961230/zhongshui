package com.ruoyi.system.mapper.zs;
import com.ruoyi.system.domain.zs.SpecialAuditModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *special_audit dao
 */
public interface SpecialAuditModelMapper{

    SpecialAuditModel findById(Integer id);

    int save(SpecialAuditModel model);

    int deleteById(Integer id);

    int updateById(SpecialAuditModel var1);

    List<SpecialAuditModel> findALL();

    Long deleteByIds(@Param("ids") List<Integer> ids);

    List<SpecialAuditModel> selectActiveList(SpecialAuditModel model);

    Integer findMaxId();
}
