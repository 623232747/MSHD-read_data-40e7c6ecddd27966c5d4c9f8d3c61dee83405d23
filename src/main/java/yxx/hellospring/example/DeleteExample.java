package yxx.hellospring.example;

import org.apache.ibatis.session.SqlSession;
import yxx.hellospring.Mapper.DeathstatisticsMapper;

import java.util.List;

//public class DeleteExample {
//    static SqlSession sqlSession;
//
//    public static void main(String[] args) {
//        // 这一步是连接数据库初始化
//        sqlSession = SessionUtil.openSession();
//        DeathstatisticsMapper mapper = (DeathstatisticsMapper)sqlSession.getMapper(DeathstatisticsMapper.class);
//        /*
//        这里可以通过 criteria.andReportingUnitNotEqualTo("xxx"); 之类的语句添加条件限制，如果无限制则默认选取全表
//         */
//        mapper.deleteByPrimaryKey("3604241000001112204");
//        sqlSession.close();
//    }
//}
