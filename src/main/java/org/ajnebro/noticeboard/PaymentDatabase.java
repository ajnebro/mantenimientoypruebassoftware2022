package org.ajnebro.noticeboard;

/**
 * @author Antonio J. Nebro
 */
public interface PaymentDatabase {
  void advertisementPublished(String advertiserName);
  boolean advertiserHasFunds(String advertiserName);
}
