
/**
* I am the sole author of all code in this class.
* SubsetIterator iterates over the power set of a given set. Sets are represented as vectors.
* @author Davey Morse
*
*/
import structure5.*;
import java.util.Iterator;
public class SubsetIterator<E> extends AbstractIterator<Vector<E>>{
  //Instance variables
  long combo; //represents in binary which of the elements of the vector we include in the left tower
  Vector <E> set; //the total set to be iterated over

  /**
  * Constructor of SubsetIterator
  * pre: set cannot have more than 62 elements
  * post: constructs an instance of SubsetIterator object
  */
  public SubsetIterator(Vector<E> set){
    super();
    //$Nice use of Asserts to catch an edge case!
    Assert.pre(set.size()<63, "Vector has more than 62 elements--long instance variable cannot handle it.");
    this.set = set;
    combo = 1;
  }
  /**
  * post: resets combo, i.e. the subset of the set we are looking at, to the first subset
  */
  public void reset(){
    combo = 1;
    //initially, combo was reset to zero, but no need to consider empty set in this context
  }
  /**
  * post: returns whether there is another subset to iterate over
  */
  public boolean hasNext(){
    //The total number of subsets is 2^n. That is because each subset either includes or does not include each element of the original set. 2 options for each element --> 2*2*2*... (n times) = 2^n
    return combo<Math.pow(2, set.size());
  }
  /**
  * pre: hasNext()
  * post: increments to next set
  * @return the current subset, prior to incrementation
  */
  public Vector<E> next(){
    Assert.pre(hasNext(), "called next() when iterator does not hasNext()");
    //$Nice work only writing this code once!
    Vector<E> current = get();
    combo++;
    return current;
  }
  /**
  * post: generates the current subset based on combo
  * @return the given subset
  */
  public Vector<E> get(){
    Vector<E> subset = new Vector<E>(); //the subset to be returned
    //for each element in the total set
    for (int i = 0; i<set.size(); i++){
      //if combo indicates that this element is included in the current subset, add this element of the total set to the subset to be returned
      if((combo & (1L << i))>0) subset.add(set.get(i));
    }
    return subset;
  }
  /**
  * toString method
  * pre: Vector toString() and get() method need to be working without error
  * post: returns string
  */
  public String toString(){
    return ("Total set: " + set.toString() + ", current subset: " + get());
  }

  /**
  * Main method, used for debugging
  * @param args unnecessary, irrelevant
  */
  public static void main(String[] args) {
    Vector <Integer> vec = new Vector<Integer>();
    vec.add(1); vec.add(2); vec.add(3);
    SubsetIterator<Integer> it = new SubsetIterator<Integer>(vec);
    System.out.println(it.toString());
    System.out.println(it.hasNext());
    while(it.hasNext()){
      System.out.println(it.next());
    }
  }
}
