package jp.co.systena.tigerscave.shoppingcart.application.service;

import java.util.ArrayList;
import java.util.List;
import jp.co.systena.tigerscave.shoppingcart.application.model.Order;

public class Cart {
  private List<Order> orderList = new ArrayList<Order>();

  public void addOrder(Order o) {
    orderList.add(o);
  }

  public List<Order> getOrderList(){
    return this.orderList;
  }

  public void setOrderList(List<Order> o) {
    this.orderList = o;
  }
}
