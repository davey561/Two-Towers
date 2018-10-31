import structure5.*;
import java.util.Iterator;
public class SubsetIterator<E> extends AbstractIterator<Vector<E>>{
  //Instance variables
  long combo; //represents in binary which of the elements of the vector we include in the left tower
  Vector <E> set; //the total set to be iterated over
  public SubsetIterator(Vector<E> set){
    super();
    Assert.pre(set.size()<63, "Vector has more than 62 elements--long variables cannot handle it.");
    this.set = set;
    combo = 1;
  }
  public void reset(){
    combo = 0;
  }
  public boolean hasNext(){
    return combo<Math.pow(2, set.size());
  }
  public Vector<E> next(){
    Vector<E> current = get();
    combo++;
    return current;
  }
  public Vector<E> get(){
    Vector<E> subset = new Vector<E>();
    for (int i = 0; i<set.size(); i++){
      if((combo & (1L << i))>0) subset.add(set.get(i));
    }
    return subset;
  }
  public String toString(){
    return ("Total set: " + set.toString() + ", current subset: " + get());
  }
  /**
  * Sums values in the subset
  * pre: E must be of type Integer/double/long
  * post: returns the sum of the values
  *
  */
  public static void main(String[] args) {
    Vector <Integer> vec = new Vector<Integer>();
    vec.add(1); vec.add(2); vec.add(3);
    SubsetIterator<Integer> it = new SubsetIterator<Integer>(vec);
    System.out.println(it.toString());
    System.out.println(it.hasNext());
    for (int i = 0; i<Math.pow(2, vec.size()); i++) {
      System.out.println(it.next());
    }
  }
}
