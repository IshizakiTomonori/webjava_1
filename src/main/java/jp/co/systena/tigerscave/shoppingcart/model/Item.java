package jp.co.systena.tigerscave.shoppingcart.model;

public class Item {
  private int itemId;
  private String name;
  private int price;

  public Item(int id, String na, int p) {
    this.itemId = id;
    this.name = na;
    this.price = p;
  }

  public int getItemId() {
    return this.itemId;
  }

  public void setItemId(int id) {
    this.itemId = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String na) {
    this.name = na;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int p) {
    this.price = p;
  }

}
