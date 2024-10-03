package oit.is.z2635.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
}
