package org.ajnebro.doubleendedqueue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Test cases:
 - The constructor creates a node with the proper value
 - The constructor creates a node with a previous and a next node
 - The node is the first node when it is created without a previous one
 - The node is the last node when it is created without a next one
 - The node is not a terminal node if it has a previous and a next
 - Inserting a node before the created node
 - Inserting a node after the created node
 - Sets the item
 - Sets the next node
 - Sets the previous node
 */
class DequeNodeTest {
  @Test
  public void constructorAssignsTheCorrectValues() {
    var node = new DequeNode<>(1, null, null) ;

    int expectedValue = 1;
    assertThat(node.getItem()).isEqualTo(expectedValue); // AssertJ example
    assertNull(node.getPrevious());
    assertNull(node.getNext());
  }

  @Test
  public void constructorAssignsTheCorrectValuesUsingReflection() {
    var node = new DequeNode<>(1, null, null) ;

    int expectedValue = 1;
    int obtainedValue = (int) ReflectionTestUtils.getField( node,"item");

    assertThat(obtainedValue).isEqualTo(expectedValue);
    assertNull(ReflectionTestUtils.getField(node, "previous"));
    assertNull(ReflectionTestUtils.getField(node, "next"));
    assertThat(ReflectionTestUtils.getField(node, "next")).isNull(); // Assertj example
  }

  @Test
  public void constructorInitializesANodeWithPreviousAndNext() {
    var previousNode = new DequeNode<>(1, null, null) ;
    var nextNode = new DequeNode<>(3, null, null ) ;
    var currentNode = new DequeNode<>(2, nextNode, previousNode) ;

    assertSame(previousNode, currentNode.getPrevious());
    assertSame(nextNode, currentNode.getNext());
  }

  @Test
  public void constructorInitializesANodeWithPreviousAndNextUsingReflection() {
    var previousNode = new DequeNode<>(1, null, null) ;
    var nextNode = new DequeNode<>(3, null, null ) ;
    var currentNode = new DequeNode<>(2, nextNode, previousNode) ;

    assertSame(previousNode, ReflectionTestUtils.getField(currentNode, "previous"));
    assertSame(nextNode, ReflectionTestUtils.getField(currentNode, "next"));
  }

  @Test
  public void aNodeIsTheFirstWhenItIsCreatedWithoutAPreviousOne() {
    var node = new DequeNode<>(3, null, null) ;
    assertTrue(node.isFirstNode());
  }

  @Test
  public void aNodeIsTheLastWhenItIsCreatedWithoutAPreviousOne() {
    var node = new DequeNode<>(3, null, null) ;
    assertTrue(node.isLastNode());
  }

  @Test
  public void aNodeIsNotTerminalWhenItHasAPreviousAndNextOne() {
    var previousNode = new DequeNode<>(1, null, null) ;
    var nextNode = new DequeNode<>(3, null, null ) ;
    var currentNode = new DequeNode<>(2, nextNode, previousNode) ;

    assertTrue(currentNode.isNotATerminalNode()) ;
  }

  @Test
  public void insertAPreviousNodeWorksProperly() {
    var previousNode = new DequeNode<>(1, null, null) ;
    var currentNode = new DequeNode<>(2, null, previousNode) ;

    assertTrue(currentNode.isNotATerminalNode()) ;
  }
}