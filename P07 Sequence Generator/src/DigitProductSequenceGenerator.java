////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P07 Sequence Generator
// Files:           Sequence.java, GeometricSequenceGenerator.java,
//                  SequenceGeneratorTests.java,
//                  FibonacciSequenceGenerator.java
//                  DigitProductSequenceGenerator.java,
//                  ArithmeticSequenceGenerator.java
// Course:          CS300, Fall 2018
//
// Author:          Stephen Fan
// Email:           sfan54@wisc.edu
// Lecturer's Name: Alexi Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates, 
//strangers, and others do.  If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The DigitProductSequenceGenerator class that generates a digit product
 * sequence. It determines the next number by taking every NON ZERO digit of 
 * the previous number, multiply them and add the product to the previous 
 * number itself. 
 * 
 * @author Stephen Fan
 *
 */
public class DigitProductSequenceGenerator {
  private final int INIT; // initial number
  private final int SIZE; // size of sequence
  private ArrayList<Integer> sequence; // ArrayList object storing the sequence

  /**
   * Constructor for the DigitProductSequenceGenerator class.
   * Creates a digit product sequence based on an initial element and a
   * sequence size.
   * Throws an IllegalArgumentException if the size is <= 0 or if the initial
   * term is <= 0 with the appropriate warning message.
   * 
   * @param init is the initial term of the sequence
   * @param size is the number of elements in the sequence
   */
  public DigitProductSequenceGenerator(int init, int size) {
    // initialize variables
    this.SIZE = size;
    this.INIT = init;

    // Throws an IllegalArgumentException if the size is <= 0 or if the initial
    // term is <= 0 with the appropriate warning message.
    if (size <= 0) {
      throw new IllegalArgumentException(
          "WARNING: CANNOT create a sequence " + "with size <= zero.");
    }
    if (init <= 0) {
      throw new IllegalArgumentException("WARNING: The starting element for "
          + "digit product sequence cannot be less than or equal to zero.");
    }

    // initializes ArrayList sequence
    sequence = new ArrayList<Integer>();

    // generates the DigitProductSequence by calling the generateSequence()
    // method
    generateSequence();

  }

  /**
   * generateSequence method generates the DigitProductSequence and adds each
   * element to the ArrayList sequence
   */
  public void generateSequence() {
    // clear the sequence ArrayList
    sequence.clear();

    // add the initial value to sequence
    sequence.add(this.INIT);

    // declare local variables
    // the current number that we mutate while calculating the product of its
    // digits (we can't change this.INIT)
    int currentNum = this.INIT; 
    
    // A copy of the current number because we end up mutating currentNum.
    // We mutate this copy to reflect the next number in the sequence.
    int currentNum2 = this.INIT; 
    
    int remainder; // the remainder from the current number
    int product; // the product of the digits of the current number

    // initialize ArrayList to hold the digits from the current number
    ArrayList<Integer> digitList = new ArrayList<Integer>();

    // fill the ArrayList with the digits from the current number
    for (int i = 0; i < this.SIZE - 1; i++) {
      // reset the currentNum to the actual current number since we change it
      // to zero while trying to obtain its digits
      currentNum = currentNum2;
      
      // clear the digitList
      digitList.clear();
      
      // While the currentNum is not zero (meaning there are no more digits
      // left in it since we remove the digit after we add it to digitList)
      // keep diving by 10. The remainder should be the last digit of the
      // number. Add this digit to digitList.
      while (currentNum != 0) {
        // calculate remainder using mod
        remainder = currentNum % 10;
        
        // If the remainder isn't zero add it to digitList. We do this because
        // the project requirements specified that nonzero digits were not
        // to be factored into our product calculations
        if (remainder != 0) {
          digitList.add(remainder);
        }
        currentNum = currentNum / 10;
      }

      // initialize product to the first digit of the current number
      product = digitList.get(0);

      // calculate the product by multiplying each element of digitList
      for (int k = 1; k < digitList.size(); k++) {
        product *= digitList.get(k);
      }

      // add the product to currentNum2
      currentNum2 += product;
      
      // add currentNum2 to the sequence ArrayList
      sequence.add(currentNum2);
    }
  }

  /**
   * Public accessor method in order to get the sequence for a test method
   * 
   * @return sequence is an ArrayList containing the DigitProductSequence
   */
  public ArrayList<Integer> getSequence() {
    return sequence;
  }

  /**
   * Public accessor method in order to get an iterator for this class
   * 
   * @return sequence.iterator() is the iterator for this class
   */
  public Iterator<Integer> getIterator() {
    return sequence.iterator();
  }

}
