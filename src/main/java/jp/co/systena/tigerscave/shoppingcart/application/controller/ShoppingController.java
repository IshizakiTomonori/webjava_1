package jp.co.systena.tigerscave.shoppingcart.application.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.shoppingcart.application.service.ListService;

@Controller
public class ShoppingController {
  @RequestMapping("/List")
  public ModelAndView list(ModelAndView mav) {
    ListService list = new ListService();
    Map item_list = list.getItemList();

    mav.addObject("ItemList", item_list);
    mav.setViewName("ListView");

    return mav;
  }

  @RequestMapping("/Order")
  public ModelAndView order(ModelAndView mav) {

    mav.setViewName("cartView");

    return mav;
  }
}
