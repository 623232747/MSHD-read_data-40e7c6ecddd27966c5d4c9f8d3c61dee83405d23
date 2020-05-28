package yxx.hellospring.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import yxx.hellospring.Mapper.*;
import yxx.hellospring.POJO.*;
import yxx.hellospring.example.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class Update_Controller {
    private SqlSession sqlSession ;

    @PostMapping("/admin/M_Death.html")
    public String death(Model model,HttpServletRequest request) throws IOException{
        String ID = request.getParameter("ID");
        String location = request.getParameter("location");
        String date = request.getParameter("date");
        int number = Integer.parseInt(request.getParameter("number"));
        String reportingUnit = request.getParameter("reporting unit");
        Deathstatistics deathstatistics = new Deathstatistics();
        deathstatistics.setId(ID);
        deathstatistics.setLocation(location);
        deathstatistics.setDate(date);
        deathstatistics.setNumber(number);
        deathstatistics.setReportingUnit(reportingUnit);
        sqlSession = SessionUtil.createSession();
        DeathstatisticsMapper mapper = (DeathstatisticsMapper) sqlSession.getMapper(DeathstatisticsMapper.class);
        mapper.updateByPrimaryKey(deathstatistics);
        System.out.println(deathstatistics.toString());
        sqlSession.commit();
        sqlSession.close();
        model.addAttribute("DeathStatistics",deathstatistics);
        model.addAttribute("result","修改成功！");
        return "admin/M_Death.html";
    }

    @PostMapping("/admin/M_Civil.html")
    public String civil(Model model,HttpServletRequest request) throws IOException{
        String ID = request.getParameter("ID");
        String location = request.getParameter("location");
        String date = request.getParameter("date");
        String basicallyIntactSquare = request.getParameter("basically intact square");
        String damagedSquare = request.getParameter("damaged square");
        String destroyedSquare = request.getParameter("destroyed square");
        String note =request.getParameter("note");
        String reportingUnit = request.getParameter("reporting unit");
        Civilstructure civilstructure = new Civilstructure();

        civilstructure.setId(ID);
        civilstructure.setLocation(location);
        civilstructure.setDate(date);
        civilstructure.setBasicallyIntactSquare(basicallyIntactSquare);
        civilstructure.setDamagedSquare(damagedSquare);
        civilstructure.setDestroyedSquare(destroyedSquare);
        civilstructure.setNote(note);
        civilstructure.setReportingUnit(reportingUnit);

        sqlSession = SessionUtil.createSession();
        CivilstructureMapper mapper = (CivilstructureMapper) sqlSession.getMapper(CivilstructureMapper.class);
        mapper.updateByPrimaryKey(civilstructure);
        System.out.println(civilstructure.toString());
        sqlSession.commit();
        sqlSession.close();
        model.addAttribute("CivilStructure",civilstructure);
        model.addAttribute("result","修改成功！");
        return "admin/M_Civil.html";
    }

    @PostMapping("/admin/M_Collapse.html")
    public String collapse(Model model,HttpServletRequest request) throws IOException{
        String ID = request.getParameter("ID");
        String location = request.getParameter("location");
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        String note = request.getParameter("note");
        byte[] picture = request.getParameter("picture").getBytes();
        String reportingUnit = request.getParameter("reporting unit");
        Collapserecord collapserecord = new Collapserecord();

        collapserecord.setId(ID);
        collapserecord.setDate(date);
        collapserecord.setLocation(location);
        collapserecord.setPicture(picture);
        collapserecord.setReportingUnit(reportingUnit);
        collapserecord.setType(type);
        collapserecord.setNote(note);
        collapserecord.setStatus(status);

        sqlSession = SessionUtil.createSession();
        CollapserecordMapper mapper = (CollapserecordMapper) sqlSession.getMapper(CollapserecordMapper.class);
        mapper.updateByPrimaryKey(collapserecord);
        System.out.println(collapserecord.toString());
        sqlSession.commit();
        sqlSession.close();
        model.addAttribute("CollapseRecord",collapserecord);
        model.addAttribute("result","修改成功！");
        return "admin/M_Collapse.html";
    }
    @PostMapping("/admin/M_Comm.html")
    public String comm(Model model,HttpServletRequest request) throws IOException{
        String ID = request.getParameter("ID");
        String location = request.getParameter("location");
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        String grade = request.getParameter("grade");
        String note = request.getParameter("note");
        byte[] picture = request.getParameter("picture").getBytes();
        String reportingUnit = request.getParameter("reporting unit");
        Commdisaster commdisaster = new Commdisaster();

        commdisaster.setId(ID);
        commdisaster.setDate(date);
        commdisaster.setLocation(location);
        commdisaster.setPicture(picture);
        commdisaster.setReportingUnit(reportingUnit);
        commdisaster.setType(type);
        commdisaster.setNote(note);
        commdisaster.setGrade(grade);

        sqlSession = SessionUtil.createSession();
        CommdisasterMapper mapper = (CommdisasterMapper) sqlSession.getMapper(CommdisasterMapper.class);
        mapper.updateByPrimaryKey(commdisaster);
        System.out.println(commdisaster.toString());
        sqlSession.commit();
        sqlSession.close();
        model.addAttribute("CommDisaster",commdisaster);
        model.addAttribute("result","修改成功！");
        return "admin/M_Comm.html";
    }
    @PostMapping("/admin/M_Disaster.html")
    public String Disaster(Model model,HttpServletRequest request) throws IOException{

        String ID = request.getParameter("ID");
        String location = request.getParameter("location");
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        String intensity = request.getParameter("intensity");
        float longitude = Float.parseFloat(request.getParameter("longitude"));
        float latitude = Float.parseFloat(request.getParameter("latitude"));
        float depth = Float.parseFloat(request.getParameter("depth"));
        float magnitude = Float.parseFloat(request.getParameter("magnitude"));
        String note = request.getParameter("note");
        byte[] picture = request.getParameter("picture").getBytes();
        String reportingUnit = request.getParameter("reporting unit");

       Disasterprediction disasterprediction = new Disasterprediction();
       disasterprediction.setId(ID);
       disasterprediction.setLocation(location);
       disasterprediction.setLatitude(latitude);
       disasterprediction.setLongitude(longitude);
       disasterprediction.setDate(date);
       disasterprediction.setType(type);
       disasterprediction.setIntensity(intensity);
       disasterprediction.setDepth(depth);
       disasterprediction.setMagnitude(magnitude);
       disasterprediction.setNote(note);
       disasterprediction.setPicture(picture);
       disasterprediction.setReportingUnit(reportingUnit);

        sqlSession = SessionUtil.createSession();
        DisasterpredictionMapper mapper = (DisasterpredictionMapper) sqlSession.getMapper(DisasterpredictionMapper.class);
        mapper.updateByPrimaryKey(disasterprediction);
        System.out.println(disasterprediction.toString());
        sqlSession.commit();
        sqlSession.close();
        model.addAttribute("DisasterPrediction",disasterprediction);
        model.addAttribute("result","修改成功！");
        return "admin/M_Disaster.html";
    }
}
