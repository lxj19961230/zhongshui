package com.ruoyi.system.mapper.zs;
import com.ruoyi.system.domain.zs.OtherTaxAssuranceModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *other_tax_assurance dao
 */
@Mapper
public interface OtherTaxAssuranceModelMapper  {

    OtherTaxAssuranceModel findById(Integer id);

    int save(OtherTaxAssuranceModel model);

    int deleteById(Integer id);

    int updateById(OtherTaxAssuranceModel var1);

    List<OtherTaxAssuranceModel> findALL();

    Long deleteByIds(@Param("ids") List<Integer> ids);

    List<OtherTaxAssuranceModel> selectActiveList(OtherTaxAssuranceModel model);

    Integer findMaxId();

}
