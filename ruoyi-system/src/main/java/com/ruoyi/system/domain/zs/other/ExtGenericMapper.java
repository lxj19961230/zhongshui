package com.ruoyi.system.domain.zs.other;

import com.ruoyi.system.domain.zs.IdModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author fish
 * @Date 11/15/2017
 */
public interface ExtGenericMapper<T extends IdModel, R> extends GenericMapper<T, R> {

  List<T> findALL();

  T findByName(@Param("name") String name);

  List<Integer> findByNames(@Param("names") List<String> names);

  List<T> findByIds(@Param("ids") List<R> ids);

  Long deleteByIds(@Param("ids") List<R> ids);
}
