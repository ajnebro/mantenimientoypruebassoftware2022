package org.ajnebro.factorial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test cases:
 * factorial 0 -> 1 *
 * factorial 1 -> 1
 * factorial 2 -> 2
 * factorial 3 -> 6
 */

class FactorialTest {

  @Test
  public void shouldComputeReturnOneIfTheNumberIsZero() {
    Factorial factorial = new Factorial() ;
    int expectedValue = 1 ;
    int obtainedValue = factorial.compute(0) ;

    assertEquals(expectedValue, obtainedValue) ;
  }
}