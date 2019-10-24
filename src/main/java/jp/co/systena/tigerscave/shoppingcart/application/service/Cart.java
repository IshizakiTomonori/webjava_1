package jp.co.systena.tigerscave.shoppingcart.application.service;

import java.util.List;
import jp.co.systena.tigerscave.shoppingcart.application.model.Order;

public class Cart {
  private List<Order> orderList;
  
  public List<Order> addOrder() {
    
    // TODO: セッションにitemIdを追加
    // セッション情報がない場合はorderListを作成する
    
    return this.orderList;
  }
}
