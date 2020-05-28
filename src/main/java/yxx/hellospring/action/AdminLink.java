package yxx.hellospring.action;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import yxx.hellospring.Mapper.*;
import yxx.hellospring.POJO.*;
import yxx.hellospring.example.SessionUtil;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminLink {


    private SqlSession sqlSession ;

    @RequestMapping("/Homepage.html")
    public String homePage() {
        return "admin/Homepage";
    }

    @RequestMapping({"/DeathStatisticsPage.html","admin/M_Death.html"})
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
        return "admin/DeathStatisticsPage";
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
        return "admin/CivilStructurePage";
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
        return "admin/CommDisasterPage";
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
        return "admin/CollapseRecordPage";
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
        return "admin/DisasterPredictionPage";
    }

    @RequestMapping("/Downloadpage.html")
    public String DownloadPage() {
        return "Downloadpage";
    }

    @RequestMapping("/UploadPage.html")
    public String UploadPage() {
        return "UploadPage";
    }



    @RequestMapping("/{type:DeathStatisticsPage|CivilStructurePage|CommDisasterPage|CollapseRecordPage|DisasterPredictionPage}/{id:[0-9]*}")
    public String AnyPage(Model model,@PathVariable(value = "id")String id,@PathVariable(value = "type")String type) {
        sqlSession = SessionUtil.createSession();
        if(type.equals("DeathStatisticsPage")){
            DeathstatisticsMapper mapper = (DeathstatisticsMapper)sqlSession.getMapper(DeathstatisticsMapper.class);
            DeathstatisticsExample example = new DeathstatisticsExample();
            DeathstatisticsExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            List<Deathstatistics> outlist = mapper.selectByExample(example);
//            sqlSession.commit();
//            sqlSession.close();
            model.addAttribute("DeathStatistics", outlist.get(0));
            sqlSession.commit();
            sqlSession.close();
            return "admin/M_Death";
        }else if(type.equals("CivilStructurePage")){
            CivilstructureMapper mapper=(CivilstructureMapper)sqlSession.getMapper(CivilstructureMapper.class);
            CivilstructureExample example=new CivilstructureExample();
            CivilstructureExample.Criteria criteria=example.createCriteria();
            criteria.andIdEqualTo(id);
            List<Civilstructure> outlist=mapper.selectByExample(example);
//            sqlSession.commit();
//            sqlSession.close();
            model.addAttribute("CivilStructure", outlist.get(0));
            sqlSession.commit();
            sqlSession.close();
            return "admin/M_Civil";
        }else if(type.equals("CommDisasterPage")){
            CommdisasterMapper mapper=(CommdisasterMapper)sqlSession.getMapper(CommdisasterMapper.class);
            CommdisasterExample example=new CommdisasterExample();
            CommdisasterExample.Criteria criteria=example.createCriteria();
            criteria.andIdEqualTo(id);
            List<Commdisaster> outlist=mapper.selectByExample(example);
//            sqlSession.commit();
//            sqlSession.close();
            model.addAttribute("CommDisaster", outlist.get(0));
            sqlSession.commit();
            sqlSession.close();
            return "admin/M_Comm";
        }else if(type.equals("CollapseRecordPage")){
            CollapserecordMapper mapper=(CollapserecordMapper)sqlSession.getMapper(CollapserecordMapper.class);
            CollapserecordExample example=new CollapserecordExample();
            CollapserecordExample.Criteria criteria=example.createCriteria();
            criteria.andIdEqualTo(id);
            List<Collapserecord> outlist=mapper.selectByExample(example);
//            sqlSession.commit();
//            sqlSession.close();
            model.addAttribute("CollapseRecord", outlist.get(0));
            sqlSession.commit();
            sqlSession.close();
            return "admin/M_Collapse";
        }else {
            DisasterpredictionMapper mapper=(DisasterpredictionMapper)sqlSession.getMapper(DisasterpredictionMapper.class);
            DisasterpredictionExample example=new DisasterpredictionExample();
            DisasterpredictionExample.Criteria criteria=example.createCriteria();
            criteria.andIdEqualTo(id);
            List<Disasterprediction> outlist=mapper.selectByExample(example);
//            sqlSession.commit();
//            sqlSession.close();
            model.addAttribute("DisasterPrediction", outlist.get(0));
            sqlSession.commit();
            sqlSession.close();
            return "admin/M_Disaster";
        }
    }
    //下载请求数据页
    @RequestMapping("/DownloadRequestPage.html")
    public String DownloadRequestPage(Model model){
        sqlSession = SessionUtil.createSession();
        DisasterrequestMapper mapper=(DisasterrequestMapper)sqlSession.getMapper(DisasterrequestMapper.class);
        DisasterrequestExample example=new DisasterrequestExample();
        DisasterrequestExample.Criteria criteria=example.createCriteria();
        criteria.andStatusEqualTo("1");
        List<Disasterrequest> finished_requestList=mapper.selectByExample(example);
        criteria.andStatusEqualTo("0");
        List<Disasterrequest> unfinished_requestList=mapper.selectByExample(example);

        sqlSession.commit();
        sqlSession.close();

        model.addAttribute("finished_requestlist", finished_requestList);
        model.addAttribute("unfinished_requestlist", unfinished_requestList);
        model.addAttribute("finished_request_num",finished_requestList.size());
        model.addAttribute("unfinished_request_num",unfinished_requestList.size());

        return "admin/DownloadRequestPage";
    }
    //回到普通页面
    @RequestMapping("/return")
    public String returnPage() {
        return "redirect:/";
    }
}
