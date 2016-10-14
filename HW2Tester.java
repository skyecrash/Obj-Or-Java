import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test class HW2.
 */
public class HW2Tester {
  
  /**
   * Test the replaceFirstK method.
   */
  @Test
  public void testReplaceFirstK() { 
    String s = new StringBuilder("").toString();
    
    // test 0
    assertEquals("Input String is empty", s, HW2.replaceFirstK("", 'a', 'b', 1));
    s = new StringBuilder("abc").toString();
    assertEquals("Replacing 0 characters, x is 0", s, HW2.replaceFirstK("abc", 'a', 'b', 0)); 
    assertEquals("Replacing 0 characters, no char match", s, HW2.replaceFirstK("abc", 'd', 'a', 1)); 
    
    // test 1
    s = new StringBuilder("aba").toString();
    assertEquals("Replacing one character with x = 1", s, HW2.replaceFirstK("abc", 'c', 'a', 1)); // Test Last
    assertEquals("Replacing one character with x > 1", s, HW2.replaceFirstK("abc", 'c', 'a', 2)); 
    s = new StringBuilder("cbccba").toString();
    assertEquals("Replacing one char with multiple instances and x = 1", s, 
                 HW2.replaceFirstK("abccba", 'a', 'c', 1)); // Test First
    
    // test many
    s = new StringBuilder("adccda").toString();
    assertEquals("Replacing multiple chars with x = # of instances of the char", s, HW2.replaceFirstK("abccba", 'b', 'd', 2)); // Test Middle
    s = new StringBuilder("dbccbd").toString();
    assertEquals("Replacing multiple chars with x > # of instances of the char", s, HW2.replaceFirstK("abccba", 'a', 'd', 3)); 
  }
  
  /**
   * Test the allChars method.
   */
  @Test
  public void testAllChars() {
    String s = new StringBuilder().toString();
    
    // test 1
    s = new StringBuilder("d").toString();
    assertEquals("Returning one char", s, HW2.allChars('d', 'd'));
    
    // test many
    s = new StringBuilder("defghijklmnop").toString();
    assertEquals("Returning multiple chars, with (int)c1 < (int)c2", s, HW2.allChars('d', 'p'));
    
    // please see written report for test of wrapping chars (i.e, 'd', 'a') - the test nearly broke my interactions pane
   
    
  }
  
  /**
   * Test the showCharOfString method.
   */
  @Test
  public void testShowCharOfString() {
    String s = new StringBuilder().toString();
    
    // test 0
    s = new StringBuilder("").toString();
    assertEquals("Both Strings are empty", s, HW2.showCharOfString("", ""));
    assertEquals("First String is empty", s, HW2.showCharOfString("", "test"));
    s = new StringBuilder("____").toString();
    assertEquals("Second String is empty", s, HW2.showCharOfString("test", ""));
    s = new StringBuilder("a").toString();
    assertEquals("Replacing 0 chars", s, HW2.showCharOfString("a", "a"));
    
    // test 1
    s = new StringBuilder("_").toString();
    assertEquals("Replacing one char", s, HW2.showCharOfString("a", "b")); // test first
    
    // test many
    s = new StringBuilder("t__s _s").toString();
    assertEquals("Replacing multiples chars in the middle", s, HW2.showCharOfString("this is", "a test")); // test middle
    s = new StringBuilder("d____do__").toString();
    assertEquals("Replacing multiple chars, including last char", s, HW2.showCharOfString("ding dong", "bod")); // test last
  }
  
  /**
   * Test the hiddenInString method.
   */
  @Test
  public void testHiddenInString() {
    String s1 = new StringBuilder("abracadabra").toString(); // will be checking against this String for most tests
    
    // test empty/zero
    assertFalse("Empty first string", HW2.hiddenInString("", "a", 1));
    assertFalse("Empty second string", HW2.hiddenInString(s1, "", 1));
    assertFalse("Both strings empty", HW2.hiddenInString("", "", 1));
    assertFalse("kTh = 0", HW2.hiddenInString(s1, "abc", 0));
    assertFalse("Negative single character match", HW2.hiddenInString(s1, "j", 1));

    // test first
    assertTrue("Positive single character match, the first char in String", HW2.hiddenInString(s1, "a", 1));
    assertTrue("s2 matches, first char start point, kTh = 1", HW2.hiddenInString(s1, "abra", 1)); // test many
    assertFalse("s2 doesn't match, first char \"start\" point, kTh = 1", HW2.hiddenInString(s1, "abrd", 1));
    assertTrue("s2 matches, first char start point, kTh > 1", HW2.hiddenInString(s1, "aad", 3));
    assertFalse("s2 doesn't match, first char \"start\" point, kTh > 1", HW2.hiddenInString(s1, "aab", 3)); 
    
    // test middle
    assertTrue("Positive single character match, in middle of String", HW2.hiddenInString(s1, "d", 1));
    assertTrue("s2 matches, middle char start point, kTh = 1", HW2.hiddenInString(s1, "cad", 1));
    assertFalse("s2 doesn't match, middle char \"start\" point, kTh = 1", HW2.hiddenInString(s1, "cab", 1));
    assertTrue("s2 matches, middle char start point, kTh > 1", HW2.hiddenInString(s1, "rcd", 2));
    assertFalse("s2 doesn't match, middle char \"start\" point, kTh > 1", HW2.hiddenInString(s1, "cbc", 3));
    assertTrue("s2 matches, middle char start point, kTh < 0", HW2.hiddenInString(s1, "bar", -3));
    assertFalse("s2 doesn't match, middle char \"start\" point, kTh < 0", HW2.hiddenInString(s1, "bac", -2));
    
    // test last
    assertTrue("Positive single character match, end of String", HW2.hiddenInString("bac", "c", 1)); // test 1
    assertTrue("s2 matches, end char start point, kTh = -1", HW2.hiddenInString(s1, "arb", -1)); // test many
    assertFalse("s2 doesn't match, end char \"start\" point, kTh = -1", HW2.hiddenInString(s1, "ard", -1));
    assertTrue("s2 matches, end char start point, kTh < -1", HW2.hiddenInString(s1, "abd", -2));
    assertFalse("s2 doesn't match, end char \"start\" point, kTh < -1", HW2.hiddenInString(s1, "aad", -3));
    
  }
  
  /**
   * Test the capitalizeWords method.
   */
  @Test
  public void testCapitalizeWords() {
    String s = new StringBuilder().toString();
    
    // test empty/zero
    s = new StringBuilder("").toString();
    assertEquals("Empty String", s, HW2.capitalizeWords(""));
    s = new StringBuilder("a").toString();
    assertEquals("No capitalization, one char", s, HW2.capitalizeWords("a"));
    s = new StringBuilder("test").toString();
    assertEquals("No capitalization, multiple chars", s, HW2.capitalizeWords("test"));
    
    // test first
    s = new StringBuilder("THIS").toString();
    assertEquals("Capitalize one word, first char is capital", s, HW2.capitalizeWords("This")); // test 1
    s = new StringBuilder("THIS is a TEST").toString();
    assertEquals("Capitalize multiple words, first char is a capital", s, HW2.capitalizeWords("This is a Test")); // test many
    
    // test middle
    s = new StringBuilder("THIS").toString();
    assertEquals("Capitalize one word, middle char is capital", s, HW2.capitalizeWords("thIs")); // test 1
    s = new StringBuilder("THIS is a TEST").toString();
    assertEquals("Capitalize multiple words, middle char is capital", s, HW2.capitalizeWords("tHis is a teSt")); // test many
    s = new StringBuilder("WHOA!nelly").toString();
    assertEquals("Capitalize one word, punctuation in middle to break word sequence", 
                 s, HW2.capitalizeWords("whOa!nelly"));
    
    // test last
    s = new StringBuilder("THIS").toString();
    assertEquals("Capitalize one word, end char is capital", s, HW2.capitalizeWords("thiS")); // test 1
    s = new StringBuilder("THIS is a TEST").toString();
    assertEquals("Capitalize multiple words, end char is capital", s, HW2.capitalizeWords("thiS is a tesT"));
    
  }
    
}