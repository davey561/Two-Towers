/** Iterates through String, character by Character
* @author Davey
* pre,post comments for each function are copy and pasted from Java Structures Bailey Textbook
*/

import structure5.*;

class CharacterIterator extends AbstractIterator<Character>{
  char [] chararr;
  int temp_index;
  /**
  * Constructor
  * pre: str is non-null
  * post: initalizes index to zero, splits string into array of characters
  */
  public CharacterIterator(String str) {
    super();
    chararr = str.toCharArray();
    temp_index = 0;
  }
  /**
  * Moves 'focus' to next element
  * pre: hasNext()
  * post: returns current value, and then increments iterator
  */
  public Character next() {
    Assert.pre(hasNext(), "Running next without next element.");
    temp_index++;
    return chararr[temp_index-1];
  }
  /**
  * Determines whether there is a next element to grab
  * post: true iff the iterator has more elements to visit
  */
  public boolean hasNext() {
    return (temp_index<chararr.length);
  }
  /**
  * Resets index to first element int array
  * pre: iterator may be initialized or even amid-traversal
  * post: reset iterator to the beginning of the structure
  */
  public void reset(){temp_index = 0;}

  /**
  * Gets current element
  * pre: there are more elements to be considered; hasNext()
  * post: returns current value; ie. value next() will return
  */
  public Character get() {
    return chararr[temp_index];
  }
  /**
  * Main class for testing
  * @param args irrelevant here
  */
  public static void main(String[] args) {
    CharacterIterator it = new CharacterIterator("Davey");
    while(it.hasNext()){
      System.out.print(it.next() + " ");
    }
    System.out.println("\nExpect D a v e y ");
  }
}
