/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   11/03/2018
 */
public class SplitterStream<T> {

  private List<T> passed;
  private List<T> notPassed;

  private SplitterStream() {}

  private SplitterStream(List<T> passed, List<T> notPassed) {
    this.passed = passed;
    this.notPassed = notPassed;
  }

  public List<T> getPassed() { return passed; }
  public void setPassed(List<T> passed) { this.passed = passed; }

  public List<T> getNotPassed() { return notPassed; }
  public void setNotPassed(List<T> notPassed) { this.notPassed = notPassed; }

  public static <T> SplitterStream<T> splitBy(Collection<T> items, Predicate<T> test) {
    List<T> passed = new LinkedList<T>();
    List<T> notPassed = new LinkedList<T>();
    items.stream().forEach(item -> {
      if(test.test(item)){
        passed.add(item);
        return;
      }
      notPassed.add(item);
    });
    return new SplitterStream<T>(passed, notPassed);
  }

  public SplitterStream<T> workWithPassed(Consumer<Stream<T>> func) {
    func.accept(passed.stream());
    return this;
  }

  public SplitterStream<T> workWithNotPassed(Consumer<Stream<T>> func) {
    func.accept(notPassed.stream());
    return this;
  }

  public static void main(String[] args) {
    List<String> names = Arrays.asList("Michael", "Alex", "Daniel", "Brain", "Mia", "Diana");
    SplitterStream<String> splitterResult = SplitterStream.splitBy(names, p -> p.startsWith("D"));
    List<String> passed = splitterResult.getPassed();
    List<String> notPassed = splitterResult.getNotPassed();
    System.out.println("Passed: " + passed);
    System.out.println("Not passed: " + notPassed);
  }
}
