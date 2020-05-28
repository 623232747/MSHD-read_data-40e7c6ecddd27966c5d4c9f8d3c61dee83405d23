/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
package yxx.hellospring.Mapper;

import yxx.hellospring.POJO.Civilstructure;
import yxx.hellospring.POJO.CivilstructureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CivilstructureMapper {
    int countByExample(CivilstructureExample example);

    int deleteByExample(CivilstructureExample example);

    int deleteByPrimaryKey(String id);

    int insert(Civilstructure record);

    int insertSelective(Civilstructure record);

    List<Civilstructure> selectByExample(CivilstructureExample example);

    Civilstructure selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Civilstructure record, @Param("example") CivilstructureExample example);

    int updateByExample(@Param("record") Civilstructure record, @Param("example") CivilstructureExample example);

    int updateByPrimaryKeySelective(Civilstructure record);

    int updateByPrimaryKey(Civilstructure record);
}