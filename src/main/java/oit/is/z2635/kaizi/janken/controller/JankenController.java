package oit.is.z2635.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {
  /**
   * POSTを受け付ける場合は@PostMappingを利用する /sample25へのPOSTを受け付けて，FormParamで指定された変数(input
   * name)をsample25()メソッドの引数として受け取ることができる
   *
   * @param username
   * @param model
   * @return
   */
  @PostMapping("/janken")
  public String sample(@RequestParam String username, ModelMap model) {
    model.addAttribute("username", username);
    return "Janken.html";
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

}
