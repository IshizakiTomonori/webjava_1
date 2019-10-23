package jp.co.systena.tigerscave.shoppingcart.application.service;

import java.util.HashMap;
import java.util.Map;
import jp.co.systena.tigerscave.shoppingcart.application.model.Item;

public class ListService {
  public Map getItemList() {
    Map<Integer, Item> item_list = new HashMap<>();
    Item item1 = new Item(10, "キーボード", 1000);
    Item item2 = new Item(20, "ノートパソコン", 100000);
    Item item3 = new Item(30, "マウス", 300);
    item_list.put(10, item1);
    item_list.put(20, item2);
    item_list.put(30, item3);
    return item_list;
  }
}
