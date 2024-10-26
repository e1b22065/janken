package oit.is.z2635.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface MatchInfoMapper {
  @Select("SELECT * from matchinfo")
  ArrayList<Match> selectAllByMatchInfo();

  @Insert("INSERT INTO MatchInfo (user1, user2, user1Hand, isActive) VALUES (#{user1},#{user2},#{user1Hand},#{isActive});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatchInfo(MatchInfo MatchInfo);
}
