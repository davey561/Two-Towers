/**
* I am the sole author of all code in this class
*TwoTowers class; primary test class, main method solves the puzzle by exhaustion
* @author Davey Morse
*
* The aim of the puzzle is to, given a set of squares with consecutive integer areas, to separate them into two stacks, the heights of which are as close to each other as puzzle. The pair of stacks that best meets this aim is the solution.
*/

import structure5.*;
import java.util.Scanner;

public class TwoTowers{
  /**
  * Solves the two tower puzzle
  * pre: args[0] must be parseable as an int
  * post: will print the perfect stacking height, the height of the best stacking, and the blocks in the best stacking (the shorter of the two stackings), the height of the second best stacking, and the blocks in the second-best stacking
  */
  public static void main(String[] args) {
    //Declarations
    Scanner scan = new Scanner(System.in);
    double temp_sum=0; //the sum of elements in the temporary subset temp_subset
    double total_sum = 0; //the total sum of the consecutive square roots
    double min_difference; //minimum difference between the subset's height and half of the total height
    double second_min_difference; //second minimum difference
    int num_blocks; //the number of blocks/elements in the total set, given by the user
    Vector <Double> set = new Vector<Double>(); //stores the full set of square roots of consecutive integers
    Vector <Double> temp_subset = new Vector<Double>(); //temporarily stores a particular subset of the consecutive integer square roots
    Vector <Double> best_subset = new Vector<Double>(); //keeps track of the best subset
    Vector <Double> second_best_subset = new Vector<Double>(); //keeps track of the best subset encountered thus far, i.e. the subset whose sum is closest to half of the total sum of consecutive square roots


    //Parse the user-given input as an integer.
      //Make sure that number input is a parseable int.
      try {
        //Assign the input number to num_blocks, if possible
        num_blocks = Integer.parseInt((args[0]));
      }
      //If can't parse, catch exception
      catch (Exception e) {
        System.out.println("no integer input");
        num_blocks =5;
      }

      //Ensure that user input is a integer greater than zero.
      while(num_blocks<=0){
        System.out.println("Please input an integer greater than zero for the total number of blocks.");
        num_blocks = Integer.parseInt(scan.nextLine());
      }

    //Insert consecutive square roots into the set vector, and calculate total sum in process.
      //for each integer up to num_blocks
      for(int i = 0; i<num_blocks; i++){
        total_sum += Math.sqrt(i+1); //add the sqrt to the total sum
        set.add(Math.sqrt(i)); //tack on the sqrt to the end of the set
      }
      //Print out total set of blocks
      System.out.println("Perfect stacking height (half of the total height): " + total_sum/2 + "\n");

    //Iterate over all possible subsets, finding the subset whose height comes closest to half of the total height.
      SubsetIterator<Double> subsetIt = new SubsetIterator<Double>(set); //initializes an iterator over the above-defined set: of consecutive integers' square roots
      min_difference = second_min_difference = total_sum/2-0; //the minimum difference between the height of the stack and the ideal height (total divided by 2) begins as largest possible value: total/2
      //while there is another element in the subset
      while(subsetIt.hasNext()){
        temp_subset = subsetIt.next(); //increment to look at next subset
        temp_sum = 0; //before calculations, height starts at zero
        //Calculate the height of the subset
        for(int i = 0; i<temp_subset.size(); i++){
          temp_sum+=temp_subset.get(i);
        }
        //If the difference between the height of this subset and the ideal height is smaller than previously encountered
        if(Math.abs(total_sum/2-temp_sum)<min_difference) {
          second_min_difference = min_difference;
          min_difference = Math.abs(total_sum/2-temp_sum); //record this as new minimum difference
          second_best_subset = best_subset; //old best subset is now second best subset
          best_subset = temp_subset; //record this as new best subset
        }
      }
      System.out.println(
        "Height of the best stacking: " + (total_sum/2-min_difference) +
        "\nBlocks in the best stacking: " + printBlockAreas(best_subset) +
        "\n\nHeight of the second-best stacking: " + (total_sum/2-second_min_difference) +
        "\nBlocks in the second-best stacking: " + printBlockAreas(second_best_subset)
      );
  }
  /**
  * Squares all items in vector and puts together in nice string
  * pre:
  * post: generates a string out squares of elements in the set wrapped with curly brackets
  * @param set the given set of numbers to square
  * @return a nice string of the set of squared numbers
  */
  protected static String printBlockAreas(Vector <Double> set){
    String result = "{";
    for(int i = 0; i<set.size(); i++){
      result += Math.round(Math.pow(set.get(i), 2)) + ", ";
    }
    //if the result string has characters (ie if there were more than 1 block)
    if(result.length()>1){
      result = result.substring(0,result.length()-2);
    }
     //account for extra comma
    result+= "}";
    return result;
  }
}
