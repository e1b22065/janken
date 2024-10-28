package oit.is.z2635.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface MatchMapper {
  @Select("SELECT * from matches")
  ArrayList<Match> selectAllByMatch();

  @Insert("INSERT INTO MATCHES (USER1,USER2,USER1HAND,USER2HAND) VALUES (#{user1},#{user2},#{user1Hand},#{user2Hand});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatch(Match match);

  @Select("SELECT * FROM MATCHES WHERE ID = #{id}")
  Match selectById(int id);

  @Update("UPDATE MATCHES SET USER1=#{user1}, USER2=#{user2}, USER1HAND=#{user1Hand}, USER2HAND=#{user2Hand}, ISACTIVE=#{isActive} WHERE id = #{id}")
  void updateById(Match match);
}
