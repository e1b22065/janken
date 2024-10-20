package oit.is.z2635.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
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
}
