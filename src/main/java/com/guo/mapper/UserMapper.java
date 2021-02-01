package com.guo.mapper;

import com.guo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {


    User findByUsernameAndPassword(String stu_num,String tel);

    User findbyname(int id);

    int updateUser(User user);


}
