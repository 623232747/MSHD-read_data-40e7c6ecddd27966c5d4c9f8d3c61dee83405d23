/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
package yxx.hellospring.Mapper;

import yxx.hellospring.POJO.Disasterprediction;
import yxx.hellospring.POJO.DisasterpredictionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DisasterpredictionMapper {
    int countByExample(DisasterpredictionExample example);

    int deleteByExample(DisasterpredictionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Disasterprediction record);

    int insertSelective(Disasterprediction record);

    List<Disasterprediction> selectByExampleWithBLOBs(DisasterpredictionExample example);

    List<Disasterprediction> selectByExample(DisasterpredictionExample example);

    Disasterprediction selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Disasterprediction record, @Param("example") DisasterpredictionExample example);

    int updateByExampleWithBLOBs(@Param("record") Disasterprediction record, @Param("example") DisasterpredictionExample example);

    int updateByExample(@Param("record") Disasterprediction record, @Param("example") DisasterpredictionExample example);

    int updateByPrimaryKeySelective(Disasterprediction record);

    int updateByPrimaryKeyWithBLOBs(Disasterprediction record);

    int updateByPrimaryKey(Disasterprediction record);
}