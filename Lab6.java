// Lilith Freed, laf70

public class Lab6 {
  
  public static int countSpaces(String s) {
    int count = 0;
    for(int i = 0; i < s.length(); i = i + 1) {
      if(s.charAt(i) == ' ') {
        count = count + 1;
      }
    }
    return count;
  }
  
  public static String removeSpaces(String s) {
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < s.length(); i = i + 1) {
      if(s.charAt(i) != ' ') {
        result.append(s.charAt(i));
      }
    }
    return result.toString();
  }
  
  public static void printEveryNthChar(String s, int n) {
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < s.length(); i = i + n) {
      result.append(s.charAt(i) + " ");
    }
    System.out.println(result);
  }
  
  public static void printDigits(int i) {
    int count = 1;
    while(count < i) {
      if(count * 10 < i) {
        System.out.print(((i % (count * 10)) / count) + ", ");
      } else {
        System.out.print(((i % (count * 10)) / count));
      }
      count = count * 10;
    }
    System.out.println();
  }
    
    
}
      
      