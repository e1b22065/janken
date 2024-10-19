package oit.is.z2635.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MatchMapper {
  @Select("SELECT * from matches")
  ArrayList<Match> selectAllByMatch();
}
