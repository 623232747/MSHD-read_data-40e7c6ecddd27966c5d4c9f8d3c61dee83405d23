/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
package yxx.hellospring.Mapper;

import yxx.hellospring.POJO.Collapserecord;
import yxx.hellospring.POJO.CollapserecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollapserecordMapper {
    int countByExample(CollapserecordExample example);

    int deleteByExample(CollapserecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(Collapserecord record);

    int insertSelective(Collapserecord record);

    List<Collapserecord> selectByExampleWithBLOBs(CollapserecordExample example);

    List<Collapserecord> selectByExample(CollapserecordExample example);

    Collapserecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Collapserecord record, @Param("example") CollapserecordExample example);

    int updateByExampleWithBLOBs(@Param("record") Collapserecord record, @Param("example") CollapserecordExample example);

    int updateByExample(@Param("record") Collapserecord record, @Param("example") CollapserecordExample example);

    int updateByPrimaryKeySelective(Collapserecord record);

    int updateByPrimaryKeyWithBLOBs(Collapserecord record);

    int updateByPrimaryKey(Collapserecord record);
}