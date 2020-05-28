package yxx.hellospring.example;/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
*/
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {
    private static SqlSessionFactory sessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    static {
        sessionFactory = new SqlSessionFactoryBuilder().build(SessionUtil.class.getResourceAsStream("/mybatis.cfg.xml"));
    }

    public static SqlSession openSession() {
        SqlSession session = threadLocal.get();
        if (null == session) {
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static SqlSession createSession() {
        SqlSession session = sessionFactory.openSession();
        threadLocal.set(session);

        return session;
    }
/*
测试是否能连接
 */
//    public static void main(String[] args) {
//        SqlSession session = openSession();
//        System.out.println(session.getConnection());
//        session.close();//关闭session
//    }
}