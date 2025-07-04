/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

public class App {
    public static void main(String[] args) {
      // 1. create a counter starting at 0000
      GroceryCounter counter = new GroceryCounter();

      // 2. show default
      System.out.println(counter.total());        // $0.00
      System.out.println(counter.overflows());    // 0

      // 3. exercise increments
      counter.tens();
      counter.hundreths();
      System.out.println(counter.total());        // $10.01

      // 4. force an overflow
      GroceryCounter c2 = new GroceryCounter(9999);
      c2.hundreths();
      System.out.println(c2.total());            // $0.00
      System.out.println(c2.overflows());        // 1

      // 5. test decrements
      counter.clear();
      counter.decrementOnes();
      System.out.println(counter.total());        // $99.00

      // 6. reset and done
      counter.clear();
      System.out.println(counter.total());        // $0.00
  }
}

