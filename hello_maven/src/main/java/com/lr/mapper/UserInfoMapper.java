package com.lr.mapper;

import com.lr.po.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    // 根据主键id获取userInfo
    UserInfo selectUserInfoById(Long id);

    // 查询所有userinfo
    List<UserInfo> selectAllUsers();

    // 新增一条数据
    Integer insertUserInfo(UserInfo userInfo);

    // 根据主键id修改用户名
    // 绑定关系看的是@Param()里面的参数名
    Integer updateUsernameById(@Param("name1") String name, @Param("id") Long id);

    // 删除一条数据
    Integer deleteUserById(Long id);

    // 根据用户名密码查询用户
    UserInfo queryByUsernameAndPWD(@Param("name1") String name, @Param("password") String password);

    List<UserInfo> queryByUsernameOrPwd(UserInfo userInfo);

    Integer updateUserInfoByParam(UserInfo userInfo);

    List<UserInfo> selectUserInfoByIds(@Param("ids")List<Long> ids);

    List<UserInfo> selectUserInfoByPages(@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize);
}
