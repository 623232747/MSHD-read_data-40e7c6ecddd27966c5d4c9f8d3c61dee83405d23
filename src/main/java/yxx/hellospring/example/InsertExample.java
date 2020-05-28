package yxx.hellospring.example;/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */

// 作为一个json->Entity模块的使用示例，用以说明（以防日后有人要用这块）

public class InsertExample {
//    static SqlSession sqlSession;
//    public static void main(String[] args) {
//
//        sqlSession = SessionUtil.openSession();
//
//        String jsonStr = "{\"Code\":'3604241000001112100',\"Date\":\"1\n" +
//                "00:00:00\",\"Number\":1,\"ReportingUnit\":'中国神奇现象研究协会'}";
//        // Parser的构造函数中参数为所选的数据源编号；parse的参数是jsonString
//        POJOInterface pojo = new Parser(202).parse(jsonStr);
//        // parse的返回值是一个接口，需要手动转成我们需要的类，所以要用反射机制来动态判断类型
//        String pojoClass = pojo.getClass().toString();
//        if(pojo instanceof Civilstructure){
//            // 这里就不写了
//        }else if (pojo instanceof Collapserecord){
//            // 这里就不写了
//        }else if (pojo instanceof Commdisaster){
//            // 这里就不写了
//        }else if (pojo instanceof Deathstatistics){
//            Deathstatistics deathstatistics = (Deathstatistics) pojo;
//            DeathstatisticsMapper mapper = (DeathstatisticsMapper) sqlSession.getMapper(DeathstatisticsMapper.class);
//            mapper.insert(deathstatistics);
//        }else if (pojo instanceof Disasterprediction){
//            // 这里就不写了
//        }
//        // 在写完数据库事务之后一定要commit
//        sqlSession.commit();
//        sqlSession.close();
////        System.out.println(pojoClass);
//    }
}
