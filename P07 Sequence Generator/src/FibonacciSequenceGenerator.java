//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P07 Sequence Generator
// Files: Sequence.java, GeometricSequenceGenerator.java,
//        SequenceGeneratorTests.java,
//        FibonacciSequenceGenerator.java
//        DigitProductSequenceGenerator.java,
//        ArithmeticSequenceGenerator.java

// Course: CS300, Fall 2018
//
// Author: Stephen Fan
// Email: sfan54@wisc.edu
// Lecturer's Name: Alexi Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;

/**
 * FibonacciSequenceGenerator class which generates a Fibonacci sequence
 * given a size. This Fibonacci sequence generator starts with 0,1,1,2...
 * 
 * @author Stephen Fan
 *
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // number of elements in this sequence
  
  //previous item in the sequence with respect to the current iteration
  private int prev; 
  
  //next item in the sequence with respect to the current iteration
  private int next; 
  private int generatedCount; // number of items generated so far


  /**
   * Constructor for the FibonacciSequenceGenerator class.
   * It creates a Fibonacci sequence based on the size that it is given.
   * It throws an IllegalArgumentException if the size is <= 0.
   * 
   * @param size is the number of elements in the Fibonacci sequence
   */
  public FibonacciSequenceGenerator(int size) {
    // checks if the size is <= 0 and throws an IllegalArgumentException
    // with the appropriate warning message
    if (size <= 0) {
      throw new IllegalArgumentException(
          "WARNING: CANNOT create a sequence " + "with size <= zero.");
    }
    
    // initializes variables
    this.SIZE = size;
    this.prev = 0;
    this.next = 1;
    this.generatedCount = 0;
  }


  /**
   * Checks if the iteration has a next element in this sequence
   * 
   * @return true if the current element in the iteration has a next element 
   * in this sequence, false otherwise
   */
  @Override
  public boolean hasNext() {
    // time complexity: O(1)
    return generatedCount < SIZE;
  }

  /**
   * Returns the next element in this arithmetic sequence iteration with 
   * respect to the numbers generated so far
   * 
   * @return the next element in this iteration
   */
  @Override
  public Integer next() {
    // time complexity: O(1)
    // check if the current element has a next element in this sequence
    if (!hasNext()) 
      return null;
    int current = prev; // set the current element to next
    generatedCount++; // increment the number of generated elements so far
    prev = next;
    
    // set the next element (multiplies the ratio by the current number)
    next += current; 
    return current; // return the current number as the generated one
  }
}
