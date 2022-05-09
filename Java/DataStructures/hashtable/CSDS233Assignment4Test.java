import org.junit.*;
import static org.junit.Assert.*;
public class CSDS233Assignment4Test {
  
  @Test
  public void testEmpty() {
    CSDS233Assignment4 test = new CSDS233Assignment4();
    
    assertEquals("", "", test.wordCount("")); //testing empty case
    assertEquals("", "", test.wordCount(" ")); //testing empty case
  }

  @Test
  public void testStandard() {
    CSDS233Assignment4 test = new CSDS233Assignment4();
    
    assertEquals("", "\"hello\"x3 \"a\"x5 ", test.wordCount("hello hello hello a*a*a*a*@#$@#$@#(*&a ")); //testing empty case
  }
  @Test
  public void testOverload() { //it is impoortant to test a long case like this because this also serves to test the rehashing method.
    CSDS233Assignment4 test = new CSDS233Assignment4();
    assertEquals("", "\"and\"x1 \"a\"x1 \"b\"x1 \"c\"x1 \"d\"x1 \"e\"x1 \"f\"x1 \"g\"x1 \"h\"x1 \"i\"x1 \"j\"x1 \"k\"x1 \"know\"x1 \"l\"x1 \"m\"x1 \"n\"x1 \"o\"x1 \"p\"x1 \"q\"x1 \"ABCs\"x1 \"r\"x1 \"s\"x1 \"t\"x2 \"u\"x1 \"v\"x1 \"w\"x1 \"x\"x1 \"me\"x1 \"y\"x1 \"z\"x1 \"with\"x1 \"my\"x1 \"time\"x1 \"sing\"x1 \"next\"x1 \"now\"x1 \"won\"x1 \"I\"x1 \"you\"x1 ", test.wordCount("a b c d e f g h i j k l m n o p q r s t u v w x y and z now I know my ABCs next time won't you sing with me"));
  }
}