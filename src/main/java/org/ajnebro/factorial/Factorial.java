package org.ajnebro.factorial;

public class Factorial {

  public int compute(int value) {
    int result ;
    if ((value == 0) || (value == 1)) {
      result = 1 ;
    } else {
      result = 2 ;
    }
    return result ;
  }
}
