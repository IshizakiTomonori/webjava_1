package jp.co.systena.tigerscave.shoppingcart.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.shoppingcart.application.model.Item;
import jp.co.systena.tigerscave.shoppingcart.application.model.Order;
import jp.co.systena.tigerscave.shoppingcart.application.service.Cart;
import jp.co.systena.tigerscave.shoppingcart.application.service.ListForm;
import jp.co.systena.tigerscave.shoppingcart.application.service.ListService;

@Controller
public class ShoppingController {

  @Autowired
  HttpSession session;                  // セッション管理

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

    // セッションからカートの情報を取得する
    Cart cart = (Cart)session.getAttribute("cartList");

    // セッションに商品情報がなければカートを初期化する
    if( cart == null) {
      cart = new Cart();
    }

    // 入力から注文を作成
    Order order = new Order();
    order.setItemId(listForm.getItemId());

    // カートオブジェクトに注文を追加する
    cart.addOrder(order);

    // カートオブジェクトをHTTP sessinに挿入
    session.setAttribute("cartList", cart);

    // 全商品のリストを取得する
    ListService list_service = new ListService();
    Map ls = list_service.getItemList();

    // 商品一覧を取得する
    List<Item> item_list = new ArrayList<>();

    // 商品一覧からitemIdをキーとして注文情報(Order型)を取得する
    // Cart型のcartからorderListを取得する
    for(int i = 0; i < cart.getOrderList().size(); i++) {
      item_list.add((Item) ls.get(cart.getOrderList().get(i).getItemId()));
    }

    // カートの中身をViewに渡す
    mav.addObject("cartList", item_list);

    // 遷移先を設定
    mav.setViewName("cartView");

    return mav;
  }
}
