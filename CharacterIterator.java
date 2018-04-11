import structure5.*;

/**
 * An iterator that iterates over the characters of a String
 */
public class CharacterIterator extends AbstractIterator<Character> {
    public CharacterIterator(String str) { }
    public Character next() { return ' '; }
    public boolean hasNext() { return false; }
    public void reset() { }
    public Character get() { return ' '; }
}
