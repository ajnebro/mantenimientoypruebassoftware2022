package org.ajnebro.factorial;

/**
 * Class providing a method that computes the factorial of
 * an integer number
 *
 * @author Antonio J. Nebro
 */
public class Factorial {

  public int compute(int value) {
    if (value < 0) {
      throw new RuntimeException("The value is negative: " + value);
    }

    int result = 1;
    for (int i = 1; i <= value; i++) {
      result *= i;
    }

    return result;
  }
}
