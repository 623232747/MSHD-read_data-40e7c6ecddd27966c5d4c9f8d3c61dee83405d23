/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
package yxx.hellospring.Mapper;

import yxx.hellospring.POJO.Disasterrequest;
import yxx.hellospring.POJO.DisasterrequestExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DisasterrequestMapper {
    int countByExample(DisasterrequestExample example);

    int deleteByExample(DisasterrequestExample example);

    int deleteByPrimaryKey(String id);

    int insert(Disasterrequest record);

    int insertSelective(Disasterrequest record);

    List<Disasterrequest> selectByExample(DisasterrequestExample example);

    Disasterrequest selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Disasterrequest record, @Param("example") DisasterrequestExample example);

    int updateByExample(@Param("record") Disasterrequest record, @Param("example") DisasterrequestExample example);

    int updateByPrimaryKeySelective(Disasterrequest record);

    int updateByPrimaryKey(Disasterrequest record);
}