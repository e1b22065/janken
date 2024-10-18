package oit.is.z2635.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("SELECT id,userName from users where id = #{id}")
  User selectById(int id);

  @Select("SELECT id, name from users")
  ArrayList<User> selectAllUsers();
}
