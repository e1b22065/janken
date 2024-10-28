package oit.is.z2635.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface MatchInfoMapper {
  @Select("SELECT * from matchinfo")
  ArrayList<MatchInfo> selectAllByMatchInfo();

  @Select("SELECT * from matchinfo where true = isActive")
  ArrayList<MatchInfo> selectAllByIsActive();

  @Insert("INSERT INTO MatchInfo (user1, user2, user1Hand, isActive) VALUES (#{user1},#{user2},#{user1Hand},#{isActive});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatchInfo(MatchInfo MatchInfo);

  @Select("SELECT * FROM MATCHINFO WHERE ID = #{id}")
  MatchInfo selectById(int id);

  @Update("UPDATE MATCHINFO SET USER1=#{user1}, USER2=#{user2}, USER1HAND=#{user1Hand}, ISACTIVE=#{isActive} WHERE id = #{id}")
  void updateById(MatchInfo matchInfo);

}
