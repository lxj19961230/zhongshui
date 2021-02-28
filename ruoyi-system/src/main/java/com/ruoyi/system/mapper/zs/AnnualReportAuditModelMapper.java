package com.ruoyi.system.mapper.zs;
import com.ruoyi.system.domain.zs.AnnualReportAuditModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *annual_report_audit dao
 */
@Mapper
public interface AnnualReportAuditModelMapper {

    AnnualReportAuditModel findById(Integer id);

    int save(AnnualReportAuditModel model);

    int deleteById(Integer id);

    int updateById(AnnualReportAuditModel var1);

    List<AnnualReportAuditModel> findALL();

    Long deleteByIds(@Param("ids") List<Integer> ids);

    List<AnnualReportAuditModel> selectActiveList(AnnualReportAuditModel model);

}
