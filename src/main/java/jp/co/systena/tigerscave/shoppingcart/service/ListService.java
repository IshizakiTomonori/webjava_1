package jp.co.systena.tigerscave.shoppingcart.service;

import java.util.HashMap;
import java.util.Map;
import jp.co.systena.tigerscave.shoppingcart.model.Item;

public class ListService {
  public Map getItemList() {
    Map<Integer, Item> item_list = new HashMap<>();
    Item item1 = new Item(1, "キーボード", 1000);
    Item item2 = new Item(2, "ノートパソコン", 100000);
    Item item3 = new Item(3, "マウス", 300);
    item_list.put(1, item1);
    item_list.put(2, item2);
    item_list.put(3, item3);
    return item_list;
  }
}
