package misc;

import java.util.Scanner;

/**
 * Created by thotap on 5/1/2017.
 */
public class Power
{
  public static void main(String[] args)
  {
    int i,x,y,result=1;
    Scanner sc=new Scanner(System.in);
    x=sc.nextInt();
    y=sc.nextInt();
    for(i=1;i<=y;i++)
      result=result*x;
    System.out.println("x^y result is:"+result);
  }
}
