package com.fx;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        CityMapper cityMapper= sqlSession.getMapper(CityMapper.class);
        City city= cityMapper.selectById(1);
        System.out.println(city);
        sqlSession.close();
    }
}
