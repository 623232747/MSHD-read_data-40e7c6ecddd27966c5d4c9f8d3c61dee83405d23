/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
package yxx.hellospring.Mapper;

import yxx.hellospring.POJO.Commdisaster;
import yxx.hellospring.POJO.CommdisasterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommdisasterMapper {
    int countByExample(CommdisasterExample example);

    int deleteByExample(CommdisasterExample example);

    int deleteByPrimaryKey(String id);

    int insert(Commdisaster record);

    int insertSelective(Commdisaster record);

    List<Commdisaster> selectByExampleWithBLOBs(CommdisasterExample example);

    List<Commdisaster> selectByExample(CommdisasterExample example);

    Commdisaster selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Commdisaster record, @Param("example") CommdisasterExample example);

    int updateByExampleWithBLOBs(@Param("record") Commdisaster record, @Param("example") CommdisasterExample example);

    int updateByExample(@Param("record") Commdisaster record, @Param("example") CommdisasterExample example);

    int updateByPrimaryKeySelective(Commdisaster record);

    int updateByPrimaryKeyWithBLOBs(Commdisaster record);

    int updateByPrimaryKey(Commdisaster record);
}