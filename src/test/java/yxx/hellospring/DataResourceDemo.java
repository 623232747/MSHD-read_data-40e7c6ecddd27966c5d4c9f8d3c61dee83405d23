package yxx.hellospring;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import yxx.hellospring.JsonParser.JsonToEntity;
import yxx.hellospring.Mapper.CivilstructureMapper;
import yxx.hellospring.POJO.Civilstructure;
import yxx.hellospring.POJO.CivilstructureExample;
import yxx.hellospring.controller.Upload_Controller;
import yxx.hellospring.example.SessionUtil;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class DataResourceDemo {
    String dataResourceFile = Upload_Controller.dataResourceFile;

    @Test
    void test_1() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(dataResourceFile, true);
            fileWriter.append("cool");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void test_2() {
//        更新数据库
        String line;
        try {
            FileReader fileReader = new FileReader(dataResourceFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                try {
                    int sourceCode;
                    String jsonStr;
                    String[] split = line.split("§");
                    sourceCode = Integer.parseInt(split[0]);
                    jsonStr = split[1];
                    new JsonToEntity(sourceCode).insert(jsonStr);
                } catch (Exception e) {
                    continue;
                }
            }
            bufferedReader.close();
            fileReader.close();
            FileWriter fileWriter = new FileWriter(dataResourceFile);

        } catch (Exception e) {
            System.out.println("插入数据出错");
        }
    }

    @Test
    void test2() {
        try {
            FileWriter fileWriter = new FileWriter(dataResourceFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("清空数据源出错");
        }
    }

    @Test
    void back_upEntity() {

    }

    @Test
    void deleteEntity() {
        SqlSession sqlSession = SessionUtil.openSession();
        long T = 60L*24L*3600L*1000L;
        CivilstructureMapper mapper = (CivilstructureMapper)sqlSession.getMapper(CivilstructureMapper.class);
        CivilstructureExample example = new CivilstructureExample();
        CivilstructureExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmm");
        String boundTime = simpleDateFormat.format(new Timestamp(System.currentTimeMillis()-T));
        criteria.andDateLessThan(boundTime);
        mapper.deleteByExample(example);
        sqlSession.commit();
        sqlSession.close();
    }
}
