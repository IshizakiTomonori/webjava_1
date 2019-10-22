package jp.co.systena.tigerscave.shoppingcart.application.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jp.co.systena.tigerscave.shoppingcart.application.service.ListService;

@Controller
public class ShoppingController {
  @RequestMapping("/List")
  public String index(HttpSession session, Model model,
      @RequestParam(name = "name", required = false) String name) {
    ListService list = new ListService();
    Map itme_list = list.getItemList();
    model.addAttribute("item_list", itme_list);


    return "ListView";
  }
}
