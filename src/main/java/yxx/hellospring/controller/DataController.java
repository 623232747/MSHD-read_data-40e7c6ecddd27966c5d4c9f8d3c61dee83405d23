package yxx.hellospring.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import yxx.hellospring.JsonParser.JsonToEntity;
import yxx.hellospring.Mapper.*;
import yxx.hellospring.POJO.*;
import yxx.hellospring.example.SessionUtil;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static java.lang.Thread.sleep;

@Controller
public class DataController {
    @Bean(name = "DataThread")
    public void test() {
        new DataThread().run();
    }

    // 内部类，更新数据，是一个内部死循环。
    // 将“更新数据”分为三个模块：更新数据库，备份并删除旧数据
    public static class DataThread implements Runnable {
        long t = 10L * 60L * 1000L;
        // 每隔10min读取一次数据源

        // 更新数据库
        String dataResourceFile = Upload_Controller.dataResourceFile;

        private void insertData() {

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
                        System.out.println(line);
                    }
                }
                bufferedReader.close();
                fileReader.close();
                FileWriter fileWriter = new FileWriter(dataResourceFile);

            } catch (Exception e) {
                System.out.println("插入数据出错");
            }
        }

        private void cleanupResource() {
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


        // 备份旧数据
        private void back_upEntity() {

        }

        // 删除旧数据

        SqlSession sqlSession;
        long T = 60L * 24L * 3600L * 1000L;
        // 最早的新闻是60天前的新闻

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmm");
        String boundTime = simpleDateFormat.format(new Timestamp(System.currentTimeMillis() - T));

        private void obsoleteCivilstructure() {
            CivilstructureMapper mapper = (CivilstructureMapper) sqlSession.getMapper(CivilstructureMapper.class);
            CivilstructureExample example = new CivilstructureExample();
            CivilstructureExample.Criteria criteria = example.createCriteria();
            criteria.andDateLessThan(boundTime);

            mapper.deleteByExample(example);
        }

        private void obsoleteCollapserecord() {
            CollapserecordMapper mapper = (CollapserecordMapper) sqlSession.getMapper(CollapserecordMapper.class);
            CollapserecordExample example = new CollapserecordExample();
            CollapserecordExample.Criteria criteria = example.createCriteria();
            criteria.andDateLessThan(boundTime);
            mapper.deleteByExample(example);
        }

        private void obsoleteCommdisaster() {
            CommdisasterMapper mapper = (CommdisasterMapper) sqlSession.getMapper(CommdisasterMapper.class);
            CommdisasterExample example = new CommdisasterExample();
            CommdisasterExample.Criteria criteria = example.createCriteria();
            criteria.andDateLessThan(boundTime);
            mapper.deleteByExample(example);
        }

        private void obsoleteDeathstatistics() {
            DeathstatisticsMapper mapper = (DeathstatisticsMapper) sqlSession.getMapper(DeathstatisticsMapper.class);
            DeathstatisticsExample example = new DeathstatisticsExample();
            DeathstatisticsExample.Criteria criteria = example.createCriteria();
            criteria.andDateLessThan(boundTime);
            mapper.deleteByExample(example);
        }

        private void obsoleteDisasterprediction() {
            DisasterpredictionMapper mapper = (DisasterpredictionMapper) sqlSession.getMapper(DisasterpredictionMapper.class);
            DisasterpredictionExample example = new DisasterpredictionExample();
            DisasterpredictionExample.Criteria criteria = example.createCriteria();
            criteria.andDateLessThan(boundTime);
            mapper.deleteByExample(example);
        }

        private void obsoleteDisasterrequest() {
            DisasterrequestMapper mapper = (DisasterrequestMapper) sqlSession.getMapper(DisasterrequestMapper.class);
            DisasterrequestExample example = new DisasterrequestExample();
            DisasterrequestExample.Criteria criteria = example.createCriteria();
            criteria.andDateLessThan(boundTime);
            mapper.deleteByExample(example);
        }


        private void obsoleteEntity() {
            sqlSession = SessionUtil.openSession();
            obsoleteCivilstructure();
            obsoleteCollapserecord();
            obsoleteCommdisaster();
            obsoleteDeathstatistics();
            obsoleteDisasterprediction();
            obsoleteDisasterrequest();
            sqlSession.commit();
            sqlSession.close();
        }

        @Override
        public void run() {
            System.out.println("数据生命周期开始");
            int i=0;
            while (true) {
                i++;
                System.out.println(String.format("第%d数据生命周期", i));
                insertData();
                cleanupResource();
                back_upEntity();
                obsoleteEntity();
                try {
                    sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
