package org.ajnebro.mocking;

public class PurchaseOrder {
  private final String productName ;
  private final int amountToBuy ;

  public PurchaseOrder(String productName, int amountToBuy) {
    this.productName = productName ;
    this.amountToBuy = amountToBuy ;
  }

  void purchase(Warehouse warehouse) {
    if (null != warehouse) {
      if (warehouse.thereAreProducts(productName, amountToBuy)) {
        warehouse.remove(productName, amountToBuy);
      }
    } else {
      throw new RuntimeException("The warehouse is null") ;
    }
  }
}
