package yxx.hellospring.example;/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
/*
注意：在建立数据库表项的时候，属性名中一定不能有空格，因为根据sql的语法，带空格的属性名在sql语句中需要用反引号··括起来
但是mybatis似乎不是足够智能，生成的xml文件中的sql语句居然是用双引号括住的，这样子在运行时会报sql语法错误
我猜测可能是我的版本对应有问题。
*/

public class Generator {

//    public static void main(String[] args) throws Exception{
//
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        File configFile = new File("D:\\课件\\课件\\软件项目管理\\NDA\\MyBatisTest2\\src\\main\\resources\\generatorConfig.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        myBatisGenerator.generate(null);
//    }
}