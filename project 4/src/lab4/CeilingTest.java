package lab4;

public class CeilingTest
{
  public static void main(String[] args)
  {
    System.out.println(Math.ceil(1.3));
    System.out.println(Math.ceil(2.0));
    System.out.println(Math.ceil(2.1));
    System.out.println(Math.ceil(-2.1));
    
    //flowchart 1 correct
    //flowchart 2 error at weight >1. ex: if weight = 3.8. 3.8 > 1 is true and the wrong equation is applied
    //flowchart 3 correct
    
  }
}
