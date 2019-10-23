package jp.co.systena.tigerscave.shoppingcart.application.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.shoppingcart.application.model.Item;
import jp.co.systena.tigerscave.shoppingcart.application.service.ListForm;
import jp.co.systena.tigerscave.shoppingcart.application.service.ListService;

@Controller
public class ShoppingController {
  @RequestMapping(value = "/List")
  public ModelAndView list(ModelAndView mav) {
    ListService list = new ListService();
    Map item_list = list.getItemList();

    mav.addObject("ItemList", item_list);
    mav.setViewName("ListView");

    return mav;
  }


  @RequestMapping(value = "/List", method = RequestMethod.POST)
  public ModelAndView order(ModelAndView mav, ListForm listForm) {
    // 商品のIDが入っている
    int item_id = listForm.getItemId();

    // 商品のリストを取得する
    ListService list_service = new ListService();
    Map ls = list_service.getItemList();

    // 探索
    Set<Integer> MapSet = ls.keySet();
    for(Iterator<Integer> n = MapSet.iterator(); n.hasNext();) {
      Item i = (Item) ls.get(n.next());
      if(item_id == i.getItemId()) {
        mav.addObject("CartItem", i);
        break;
      }
    }

    mav.setViewName("cartView");

    return mav;
  }
}
