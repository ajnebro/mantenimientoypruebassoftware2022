package org.ajnebro.doubleendedqueue;

import java.util.Comparator;

public interface DoubleEndedQueueV2<T> {
  void append(T item) ;
  void appendLeft(T item) ;
  void deleteFirst() ;
  void deleteLast() ;
  T peekFirst() ;
  T peekLast() ;
  int size() ;

  boolean contains(T item) ;
  T getAt(int position) ;
  void delete(T item) ;
  void sort(Comparator<?> comparator) ;
}
