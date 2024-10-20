package oit.is.z2635.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("SELECT name from users where id = #{id}")
  String selectById(int id);

  @Select("SELECT id from users where name = #{name}")
  int selectByName(String name);

  @Select("SELECT * from users where id = #{id}")
  User selectByAllid(int id);

  @Select("SELECT id, name from users")
  ArrayList<User> selectAllUsers();
}
