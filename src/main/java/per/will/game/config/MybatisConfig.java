package per.will.game.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by will on 2020/6/19.
 */
public class MybatisConfig {

    private static SqlSessionFactory sqlSessionFactory = null;

    private MybatisConfig() {

    }

    public static SqlSessionFactory getSqlSessionFactory() {
        InputStream inputStream = null;
        if (null == sqlSessionFactory) {
            String resource = "mybatis-config.xml";
            try {
                // Reader reader=Resources.getResourceAsReader(resource);  // 可以用Reader替换inputStream
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                return sqlSessionFactory;
            } catch (Exception e) {
                System.err.println(e);
                e.getStackTrace();
            }
        }
        return sqlSessionFactory;
    }

}
