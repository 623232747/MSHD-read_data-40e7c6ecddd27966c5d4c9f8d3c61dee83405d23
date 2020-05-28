package yxx.hellospring.example;

import org.apache.ibatis.session.SqlSession;
import yxx.hellospring.example.SessionUtil;
import yxx.hellospring.Mapper.CivilstructureMapper;
import yxx.hellospring.POJO.Civilstructure;
import yxx.hellospring.POJO.CivilstructureExample;

import java.util.List;

public class SelectExample {
    static SqlSession sqlSession;


/*
可怜的做界面显示模块的小朋友们，你们要学一下 MyBatis 中 Criteria 的使用了
简单点儿说，就是把 sql语句写成类的形式
要用到 POJO包里的各种 Example（不是这个包里的Example，是POJO包里的，下文简称POJOExample），不过看看函数名就行了，不用深究
下面举一个“选择 civilstructure表的所有值”的例子
假设需要的表对应的POJO是 T，那么输入应该是TExample.class，输出会是 List<T>（当然你也可以自由发挥。。。）
（如果你想把这个写得好看一点，可以像JsonParser包里的Parser函数一样，用接口的方式来声明返回值，并在返回的时候给出不同类型的返回，
当然，在接收的时候需要用反射机制来判断类型）
加油！
 */
//    public static void main(String[] args) {
//        // 这一步是连接数据库初始化
//        sqlSession = SessionUtil.openSession();
//        CivilstructureMapper mapper = (CivilstructureMapper)sqlSession.getMapper(CivilstructureMapper.class);
//        CivilstructureExample example = new CivilstructureExample();
//        CivilstructureExample.Criteria criteria = example.createCriteria();
//        /*
//        这里可以通过 criteria.andReportingUnitNotEqualTo("xxx"); 之类的语句添加条件限制，如果无限制则默认选取全表
//         */
//        List<Civilstructure> civilstructureList = mapper.selectByExample(example);
//        for (Civilstructure civilstructure:civilstructureList){
//            System.out.println(civilstructure.toString());
//        }
//    }
}
