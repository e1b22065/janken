package oit.is.z2635.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2635.kaizi.janken.model.User;
import oit.is.z2635.kaizi.janken.model.UserMapper;
import oit.is.z2635.kaizi.janken.model.Match;
import oit.is.z2635.kaizi.janken.model.MatchMapper;

@Controller
public class JankenController {

  @Autowired
  UserMapper UserMapper;

  @Autowired
  MatchMapper MatchMapper;

  /**
   *
   * @param model Thymeleafにわたすデータを保持するオブジェクト
   * @param prin  ログインユーザ情報が保持されるオブジェクト
   * @return
   */
  @GetMapping("/janken")
  public String sample(ModelMap model) {
    ArrayList<User> user = UserMapper.selectAllUsers();
    model.addAttribute("users", user);
    ArrayList<Match> match = MatchMapper.selectAllByMatch();
    model.addAttribute("matchs", match);
    return "janken.html";
  }

  @GetMapping("/match")
  public String match(@RequestParam Integer id, ModelMap model) {
    User user = UserMapper.selectByAllid(id);
    model.addAttribute("user", user);
    return "match.html";
  }

  /**
   * クエリパラメータの引数2つを受け付ける URLでの?のあとのパラメータ名とjavaメソッドの引数名は同じであることが望ましい(別にする方法は一応ある)
   * 引数をStringとして受け取ってparseIntする以外にもInteger(intのラッパークラス)クラスの変数として受け取ってそのまま加算する方法もある
   *
   * @param userhand
   * @param model
   * @return
   */
  @GetMapping("/jankengame")
  public String sample23(@RequestParam String hand, ModelMap model) {
    String Gu = "Gu";
    String Tyoki = "Tyoki";
    model.addAttribute("hand", hand);
    if (hand.equals(Gu)) {
      model.addAttribute("Result", "Draw");
    } else if (hand.equals(Tyoki)) {
      model.addAttribute("Result", "You Lose");
    } else {
      model.addAttribute("Result", "You Win!");
    }
    // ModelMap型変数のmodelにtasuResult2という名前の変数で，tasuResultの値を登録する．
    // ここで値を登録するとthymeleafが受け取り，htmlで処理することができるようになる
    return "janken.html";
  }

  @GetMapping("/fight")
  public String jankengame(@RequestParam Integer id, @RequestParam String hand, ModelMap model, Principal prin) {
    String Gu = "Gu";
    String Tyoki = "Tyoki";
    String loginUser = prin.getName();
    int player_id = UserMapper.selectByName(loginUser);

    User user = UserMapper.selectByAllid(id);
    model.addAttribute("user", user);

    ArrayList<User> users = UserMapper.selectAllUsers();
    model.addAttribute("users", users);

    Match match_fight = new Match();
    match_fight.setUser1(player_id);
    match_fight.setUser2(id);
    match_fight.setUser1Hand(hand);
    match_fight.setUser2Hand(Gu);
    MatchMapper.insertMatch(match_fight);

    model.addAttribute("hand", hand);
    if (hand.equals(Gu)) {
      model.addAttribute("Result", "Draw");
    } else if (hand.equals(Tyoki)) {
      model.addAttribute("Result", "You Lose");
    } else {
      model.addAttribute("Result", "You Win!");
    }

    return "match.html";
  }
}
