package dao;

import model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper //标记是一个接口映射类
public interface UserMapper {
    @Update("update user set name=#{name} where id = #{id}")
    int updateUser(@Param("name") String name, @Param("id") int id);

    User selectUser(int id);//sql在xml中
}