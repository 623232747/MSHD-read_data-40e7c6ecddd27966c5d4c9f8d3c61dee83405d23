/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
package yxx.hellospring.Mapper;

import yxx.hellospring.POJO.Deathstatistics;
import yxx.hellospring.POJO.DeathstatisticsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeathstatisticsMapper {
    int countByExample(DeathstatisticsExample example);

    int deleteByExample(DeathstatisticsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Deathstatistics record);

    int insertSelective(Deathstatistics record);

    List<Deathstatistics> selectByExample(DeathstatisticsExample example);

    Deathstatistics selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Deathstatistics record, @Param("example") DeathstatisticsExample example);

    int updateByExample(@Param("record") Deathstatistics record, @Param("example") DeathstatisticsExample example);

    int updateByPrimaryKeySelective(Deathstatistics record);

    int updateByPrimaryKey(Deathstatistics record);
}