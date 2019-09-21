//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P07 Sequence Generator
// Files: Sequence.java, GeometricSequenceGenerator.java,
//        SequenceGeneratorTests.java,
//        FibonacciSequenceGenerator.java
//        DigitProductSequenceGenerator.java,
//        ArithmeticSequenceGenerator.java
//
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

import java.util.ArrayList;

/**
 * Test class for the GeometricSequenceGenerator, the 
 * FibonacciSequenceGenerator, and the DigitProductSequenceGenerator classes
 * 
 * @author Stephen Fan
 *
 */
public class SequenceGeneratorTests {
  /**
   * test method for the GeometricSequenceGenerator class
   * 
   * @return passed is whether the test passed or not
   */
  public static boolean geometricSequenceGeneratorTest() {
    // represents whether the test passed or not
    boolean passed = false;
    
    // the sum of all the terms in the geometric sequence
    int sum = 0;
    
    // create a new GeometricSequenceGenerator with initial term 1, ratio 2,
    // and size 3
    GeometricSequenceGenerator geoSequence = new 
      GeometricSequenceGenerator(1, 2, 3);
    
    // While there are still more terms in the sequence, set the current number
    // to the next term in the sequence and add it to the sum. This calculates 
    // the sum of all the elements in the sequence 
    while (geoSequence.hasNext() == true) {
      int currentNum = geoSequence.next();
      sum += currentNum;
    }
    
    // if the sum total is 7, which is what it should be, then the geometric
    // sequence was correctly produced
    if (sum == 7) {
      passed = true;
    }
    
    return passed;
  }

  /**
   * Test method for the FibonacciSequenceGenerator class
   * 
   * @return passed is whether the test passed or not
   */
  public static boolean fibonacciSequenceGeneratorTest() {
    // represents whether this test passed or not
    boolean passed = false;
    
    // represents the sum of all the elements in the list
    int sum = 0;
    
    // creates a new FibonacciSequenceGenerator with size 6
    FibonacciSequenceGenerator fibSequence = new FibonacciSequenceGenerator(6);
    
    // While there are more elements in the sequence, set the current number to
    // the next element and add the current number to sum. This calculates the
    // sum of all elements in the sequence.
    while (fibSequence.hasNext() == true) {
      int currentNum = fibSequence.next();
      sum += currentNum;
    }
    
    // If the sum is 12, which is what it should be, then the Fibonacci 
    // sequence generated is correct
    if (sum == 12) {
      passed = true;
    }
    
    return passed;
  }

  /**
   * Test method for the DigitProductSequenceGenerator class
   * 
   * @return passed is whether the test passed or not
   */
  public static boolean digitProductSequenceGeneratorTest() {
    // represents whether this test passed or not
    boolean passed = false;

    // represents the sum of all elements in the sequence
    int sum = 0;

    // create a new DigitProductSequenceGenerator with initial term 13 and
    // size 3 and make it generate a sequence
    DigitProductSequenceGenerator digSequence = new 
      DigitProductSequenceGenerator(13, 3);
    digSequence.generateSequence();

    // create an ArrayList to hold the sequence obtained from
    // DigitProductSequenceGenerator
    ArrayList<Integer> sequence = digSequence.getSequence();

    // calculate the sum of all the elements in the ArrayList
    for (int i = 0; i < sequence.size(); i++) {
      sum += sequence.get(i);
    }

    // if the sum is 51, which is what it should be, then
    // DigitProductSequenceGenerator correctly generated its appropriate
    // sequence
    if (sum == 51) {
      passed = true;
    }

    return passed;
  }

  /**
   * Another test method for the DigitProductSequenceGenerator class.
   * This one checks when the initial term has a zero in it (initial = 10).
   * The zero should not be counted when calculating the following digits.
   * 
   * @return passed is whether the test passed or not
   */
  public static boolean digitProductSequenceGeneratorTest2() {
    // represents whether this test passed or not
    boolean passed = false;

    // represents the sum of all elements in the sequence
    int sum = 0;

    // create a new DigitProductSequenceGenerator with initial term 10 and
    // size 4 and make it generate a sequence
    DigitProductSequenceGenerator digSequence = new 
      DigitProductSequenceGenerator(10, 4);
    digSequence.generateSequence();

    // create an ArrayList to hold the sequence obtained from
    // DigitProductSequenceGenerator
    ArrayList<Integer> sequence = digSequence.getSequence();

    // calculate the sum of all the elements in the ArrayList
    for (int i = 0; i < sequence.size(); i++) {
      sum += sequence.get(i);
    }

    // if the sum is 47, which is what it should be, then
    // DigitProductSequenceGenerator correctly generated its appropriate
    // sequence
    if (sum == 47) {
      passed = true;
    }

    return passed;
  }

  /**
   * Main method to run all 4 tests in this test class
   * 
   * @param args
   */
  public static void main(String args[]) {
    System.out.println("GeometricSequenceGeneratorTest() has returned " 
      + geometricSequenceGeneratorTest() + ".");
    System.out.println("FibonacciSequenceGeneratorTest() has returned " 
      + fibonacciSequenceGeneratorTest() + ".");
    System.out.println("DigitProductSequenceGeneratorTest() has returned "
      + digitProductSequenceGeneratorTest() + ".");
    System.out.println("DigitProductSequenceGeneratorTest2() has returned "
      + digitProductSequenceGeneratorTest2() + ".");
  }
}
