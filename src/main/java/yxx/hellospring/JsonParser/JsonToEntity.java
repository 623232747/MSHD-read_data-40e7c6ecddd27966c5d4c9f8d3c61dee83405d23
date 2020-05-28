package yxx.hellospring.JsonParser;/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
*/

// 这个是真的主类，调用这个就行

import yxx.hellospring.Mapper.*;
import yxx.hellospring.POJO.*;
import org.apache.ibatis.session.SqlSession;
import yxx.hellospring.example.SessionUtil;

public class JsonToEntity {
    static SqlSession sqlSession;
    int resourceCode;

    public JsonToEntity(int resourceCode) {
        this.resourceCode = resourceCode;
        sqlSession = SessionUtil.createSession();
    }

    public void insert(String jsonStr) {
        POJOInterface pojo = new Parser(resourceCode).parse(jsonStr);
        String pojoClass = pojo.getClass().toString();
        if (pojo instanceof Civilstructure) {
            Civilstructure civilstructure = (Civilstructure) pojo;
            CivilstructureMapper mapper = (CivilstructureMapper) sqlSession.getMapper(CivilstructureMapper.class);
            mapper.insert(civilstructure);
        } else if (pojo instanceof Collapserecord) {
            Collapserecord collapserecord = (Collapserecord) pojo;
            CollapserecordMapper mapper = (CollapserecordMapper) sqlSession.getMapper(CollapserecordMapper.class);
            mapper.insert(collapserecord);
        } else if (pojo instanceof Commdisaster) {
            Commdisaster commdisaster = (Commdisaster) pojo;
            CommdisasterMapper mapper = (CommdisasterMapper) sqlSession.getMapper(CommdisasterMapper.class);
            mapper.insert(commdisaster);
        } else if (pojo instanceof Deathstatistics) {
            Deathstatistics deathstatistics = (Deathstatistics) pojo;
            DeathstatisticsMapper mapper = (DeathstatisticsMapper) sqlSession.getMapper(DeathstatisticsMapper.class);
            mapper.insert(deathstatistics);
        } else if (pojo instanceof Disasterprediction) {
            Disasterprediction disasterprediction = (Disasterprediction) pojo;
            DisasterpredictionMapper mapper = (DisasterpredictionMapper) sqlSession.getMapper(DisasterpredictionMapper.class);
            mapper.insert(disasterprediction);
        }
        sqlSession.commit();
        sqlSession.close();
    }

}
