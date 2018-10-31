import structure5.*;
class CharacterIterator extends AbstractIterator<Character>{
  char [] chararr;
  int temp_index;
  public CharacterIterator(String str) {
    super();
    chararr = str.toCharArray();
    temp_index = 0;
  }
  public Character next() {
    Assert.pre(hasNext(), "Running next without next element.");
    temp_index++;
    return chararr[temp_index-1];
  }
  public boolean hasNext() {
    return (temp_index<chararr.length);
  }
  public void reset(){temp_index = 0;}
  public Character get() {
    return chararr[temp_index];
  }
  public static void main(String[] args) {
    CharacterIterator it = new CharacterIterator("Davey");
    while(it.hasNext()){
      System.out.print(it.next() + " ");
    }
    System.out.println("\nExpect D a v e y ");
  }
}
