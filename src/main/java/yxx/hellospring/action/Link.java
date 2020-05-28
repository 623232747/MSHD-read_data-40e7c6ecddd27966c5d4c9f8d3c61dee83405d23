package yxx.hellospring.action;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yxx.hellospring.Mapper.*;
import yxx.hellospring.POJO.*;
import yxx.hellospring.example.SessionUtil;

import java.util.List;


@Controller
@RequestMapping("/")
public class Link {

    private SqlSession sqlSession ;
    @RequestMapping("/")
    public String homePage() {
        return "Homepage";
    }

    @RequestMapping("/Homepage.html")
    public String anotherHomePage() {
        return "Homepage";
    }

    @RequestMapping("/DeathStatisticsPage.html")
    public String DeathStatisticsPage(Model model) {
        sqlSession = SessionUtil.createSession();
        DeathstatisticsMapper mapper = (DeathstatisticsMapper)sqlSession.getMapper(DeathstatisticsMapper.class);
        DeathstatisticsExample example = new DeathstatisticsExample();
        DeathstatisticsExample.Criteria criteria = example.createCriteria();
        /*
        这里可以通过 criteria.andReportingUnitNotEqualTo("xxx"); 之类的语句添加条件限制，如果无限制则默认选取全表
         */
        List<Deathstatistics> deathStatisticseList = mapper.selectByExample(example);
        sqlSession.commit();
        sqlSession.close();
        model.addAttribute("all", deathStatisticseList);
        return "DeathStatisticsPage";
    }

    @RequestMapping("/CivilStructurePage.html")
    public String CivilStructure(Model model) {
        sqlSession = SessionUtil.createSession();
        CivilstructureMapper mapper=(CivilstructureMapper)sqlSession.getMapper(CivilstructureMapper.class);
        CivilstructureExample example=new CivilstructureExample();
        CivilstructureExample.Criteria criteria=example.createCriteria();
        List<Civilstructure> civilstructureList=mapper.selectByExample(example);
        sqlSession.commit();
        sqlSession.close();
        model.addAttribute("all", civilstructureList);
        return "CivilStructurePage";
    }

    @RequestMapping("/CommDisasterPage.html")
    public String CommDisasterPage(Model model) {
        sqlSession = SessionUtil.createSession();
        CommdisasterMapper mapper=(CommdisasterMapper)sqlSession.getMapper(CommdisasterMapper.class);
        CommdisasterExample example=new CommdisasterExample();
        CommdisasterExample.Criteria criteria=example.createCriteria();
        List<Commdisaster> CommdisasterList=mapper.selectByExample(example);
        sqlSession.commit();
        sqlSession.close();
        model.addAttribute("all", CommdisasterList);
        return "CommDisasterPage";
    }

    @RequestMapping("/CollapseRecordPage.html")
    public String CollapseRecordPage(Model model) {
        sqlSession = SessionUtil.createSession();
        CollapserecordMapper mapper=(CollapserecordMapper)sqlSession.getMapper(CollapserecordMapper.class);
        CollapserecordExample example=new CollapserecordExample();
        CollapserecordExample.Criteria criteria=example.createCriteria();
        List<Collapserecord> CollapserecordList=mapper.selectByExample(example);
        sqlSession.commit();
        sqlSession.close();
        model.addAttribute("all", CollapserecordList);
        return "CollapseRecordPage";
    }

    @RequestMapping("/DisasterPredictionPage.html")
    public String DisasterPredictionPage(Model model) {
        sqlSession = SessionUtil.createSession();
        DisasterpredictionMapper mapper=(DisasterpredictionMapper)sqlSession.getMapper(DisasterpredictionMapper.class);
        DisasterpredictionExample example=new DisasterpredictionExample();
        DisasterpredictionExample.Criteria criteria=example.createCriteria();
        List<Disasterprediction> DisasterpredictionList=mapper.selectByExample(example);
        sqlSession.commit();
        sqlSession.close();
        model.addAttribute("all", DisasterpredictionList);
        return "DisasterPredictionPage";
    }

    @RequestMapping("/Downloadpage.html")
    public String DownloadPage() {
        return "DownloadPage";
    }

    @RequestMapping("/UploadPage.html")
    public String UploadPage() {
        return "UploadPage";
    }


}
