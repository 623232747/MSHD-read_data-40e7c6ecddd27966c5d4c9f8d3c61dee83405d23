package yxx.hellospring.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import yxx.hellospring.Mapper.*;
import yxx.hellospring.POJO.*;
import yxx.hellospring.example.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class Download_Controller {

    @Autowired
    private HttpServletRequest request;
    static SqlSession sqlSession;

    // 处理 GET 请求
    @GetMapping("/Downloadpage.html")
    public String download(){return "Downloadpage";};

    // 处理 POST 请求
    @PostMapping("/Downloadpage.html")
    public void downloadSubmit(@RequestParam("url") String url,
                               @RequestParam("tableid") String tableid,
                               HttpServletResponse response) throws IOException {

        // 下载前的准备
        String filepath = tableid+"/";
        String tablename = getTableName(tableid);
        String filename = tablename + ".json";
        File file = new File(filepath + filename);
        file.getParentFile().mkdirs(); //创建文件夹
        PrintStream ps = new PrintStream(new FileOutputStream(file));

        sqlSession = SessionUtil.createSession();

        // 将请求记录写入数据库
        Disasterrequest disasterrequest = new Disasterrequest();
        String request_id = getRandomID(10);
        disasterrequest.setId(request_id);
        disasterrequest.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        disasterrequest.setDisastertype(tableid);
        disasterrequest.setStatus("0");

        // 若用户未手动输入 URL， 则保存访问 URL
        if(url.isEmpty())
            disasterrequest.setoUrl(request.getRemoteAddr());
        else
            disasterrequest.setoUrl(url);


        DisasterrequestMapper request_mapper = sqlSession.getMapper(DisasterrequestMapper.class);
        request_mapper.insert(disasterrequest);

        sqlSession.commit();


        // 人员伤亡及失踪
        if(tableid.equals("111")) {

            DeathstatisticsMapper mapper = (DeathstatisticsMapper) sqlSession.getMapper(DeathstatisticsMapper.class);
            DeathstatisticsExample example = new DeathstatisticsExample();
            List<Deathstatistics> DeathstatisticsList = mapper.selectByExample(example);


            for (Deathstatistics Deathstatistics : DeathstatisticsList) {
                ps.append(Deathstatistics.toString()+'\n');
            }
        }

        //房屋破坏
        else if(tableid.equals("221")){
            CivilstructureMapper mapper = (CivilstructureMapper) sqlSession.getMapper(CivilstructureMapper.class);
            CivilstructureExample example = new CivilstructureExample();
            List<Civilstructure> CivilstructureList = mapper.selectByExample(example);

            for (Civilstructure Civilstructure : CivilstructureList) {
                ps.append(Civilstructure.toString()+'\n');
            }
        }

        //生命线工程灾情
        else if(tableid.equals("336")){
            CommdisasterMapper mapper = (CommdisasterMapper) sqlSession.getMapper(CommdisasterMapper.class);
            CommdisasterExample example = new CommdisasterExample();
            List<Commdisaster> CommdisasterList = mapper.selectByExample(example);


            for (Commdisaster Commdisaster : CommdisasterList) {
                ps.append(Commdisaster.toString()+'\n');
            }
        }

        // 次生灾害
        else if(tableid.equals("441")){
            CollapserecordMapper mapper = (CollapserecordMapper) sqlSession.getMapper(CollapserecordMapper.class);
            CollapserecordExample example = new CollapserecordExample();
            List<Collapserecord> CollapserecordList = mapper.selectByExample(example);


            for (Collapserecord Collapserecord : CollapserecordList) {
                ps.append(Collapserecord.toString()+'\n');
            }
        }

        // 震情
        else if(tableid.equals("552")){
            DisasterpredictionMapper mapper = (DisasterpredictionMapper) sqlSession.getMapper(DisasterpredictionMapper.class);
            DisasterpredictionExample example = new DisasterpredictionExample();
            List<Disasterprediction> DisasterpredictionList = mapper.selectByExample(example);


            for (Disasterprediction Disasterprediction : DisasterpredictionList) {
                ps.append(Disasterprediction.toString()+'\n');
            }
        }

        // 无匹配表格
        else
            return ;

        ps.close();

        // 确定文件类型
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType == null){
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //传输文件

        OutputStream outputStream = response.getOutputStream();
        FileCopyUtils.copy(inputStream, outputStream);
        response.flushBuffer();
        inputStream.close();
        outputStream.close();


        // 完成输出后改变请求记录的状态
        disasterrequest.setStatus("1");
        request_mapper.updateByPrimaryKey(disasterrequest);

        sqlSession.commit();
        sqlSession.close();

        return ;
    }

    // 据 id 返回表格名
    public String getTableName(String tableid){
        String tablename="";

        if(tableid.equals("111"))
            tablename = "DeathStatistics";
        else if(tableid.equals("221"))
            tablename = "CivilStructure";
        else if(tableid.equals("336"))
            tablename = "CommDisaster";
        else if(tableid.equals("441"))
            tablename = "CollapseRecord";
        else if(tableid.equals("552"))
            tablename = "DisasterPrediction";
        return tablename;
    }

    // 随机生成记录主键
    public  String getRandomID(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}

