package com.lr;

import com.lr.mapper.UserInfoMapper;
import com.lr.po.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        //抽取方法的快捷键 ctrl+alt+m
        //getAllUserInfo();
        //updateUsernameById(sqlSession, mapper);
        //insertUserInfo();
        //deleteUserById();
        //queryByUsernameAndPWD();
        //queryByUsernameOrPwd();
        //updateUserInfoByParam();
        //selectUserInfoByIds();
        SqlSession sqlSession = getSqlSeesion();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfo> userInfos = mapper.selectUserInfoByPages(5,5);
        userInfos.forEach(e->System.out.println("userinfo:"+e));
        sqlSession.close();
    }

    private static void selectUserInfoByIds() throws IOException {
        SqlSession sqlSession = getSqlSeesion();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfo> userInfos = mapper.selectUserInfoByIds(Arrays.asList(1L,2L));
        userInfos.forEach(e->System.out.println("userinfo:"+e));
        sqlSession.close();
    }

    private static void updateUserInfoByParam() throws IOException {
        SqlSession sqlSession = getSqlSeesion();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("tom1");
        userInfo.setUserPassword("111111");
        userInfo.setUserId(2L);
        mapper.updateUserInfoByParam(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void queryByUsernameOrPwd() throws IOException {
        SqlSession sqlSession = getSqlSeesion();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("tom");
        userInfo.setUserPassword("1233456");
        //返回对象自动补全 ctrl+alt+v
        List<UserInfo> userInfos = mapper.queryByUsernameOrPwd(userInfo);
        userInfos.forEach(e -> System.out.println("userinfo:" + e));
        sqlSession.close();
    }

    private static void queryByUsernameAndPWD() throws IOException {
        SqlSession sqlSession = getSqlSeesion();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = mapper.queryByUsernameAndPWD("'tom","'1233456'");
        System.out.println(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void deleteUserById() throws IOException {
        SqlSession sqlSession = getSqlSeesion();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        mapper.deleteUserById(4L);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void insertUserInfo() throws IOException {
        SqlSession sqlSession = getSqlSeesion();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("ls");
        userInfo.setUserPassword("root123");
        mapper.insertUserInfo(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void updateUsernameById(SqlSession sqlSession, UserInfoMapper mapper) {
        mapper.updateUsernameById("zs4", 3L);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void getAllUserInfo() throws IOException {
        SqlSession sqlSession = getSqlSeesion();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        //UserInfo userInfo = mapper.selectUserInfoById(1L);
        List<UserInfo> userInfos = mapper.selectAllUsers();
        userInfos.forEach(e -> System.out.println("userInfo:" + e));
    }

    private static SqlSession getSqlSeesion() throws  IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    private static void getMysqlSimple() throws IOException{
        SqlSession sqlSession = getSqlSeesion();
        UserInfo user = sqlSession.selectOne("selectUserInfoById", 1);
        System.out.println(user);
        sqlSession.close();
    }
}
