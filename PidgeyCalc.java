 //This progam calculates the maximum experience a player can earn in pokemon go for pidgey evolutions, taking as input
 //the number of pidgey and pidgey candies the player has.import java.util.*;
import java.util.*;

public class PidgeyCalc
{ 
  public static void main (String[] args)
  {
    int pidgey;
    int startPidgey;
    int tPidgey = 0;
    int tPidgeotto = 0;
    int pidgeotto = 0;
    int startPidgeotto;
    int candy;
    int evolves = 0;
    int xp = 0;
    
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter number of pidgey's.");
    pidgey = keyboard.nextInt();
    System.out.println("Please enter number of candies.");
    candy = keyboard.nextInt(); 
    keyboard.close();
    int x = candy + pidgey + pidgeotto;
    
    //checks to see if there are enough pidgey and candy to evolve any pidgey
    while (x > 12 && pidgey > 0)
    {
      startPidgey = pidgey;
      startPidgeotto = pidgeotto;
      int tempCandy = 0;

      //determines how many pidgeotto and pidgey to transfer if the player has any pidgeotto
      if (x >= 12 && pidgeotto > 0)
      { 
        //if the player has 12 or more candy then no pidgeotto or pidgey are transferred
        if (candy >= 12)
        {
          tempCandy = candy % 12;
          candy = (candy - candy % 12);
        }
        else
        {
          //if there isn't enough pidgeotto and candy to evolve a pidgey then this if block determines
          //how many pidgey to transfer
          if ((pidgeotto + candy)< 12)
          {
             tPidgey = 12 - (x -pidgey)%12;
             tPidgeotto = pidgeotto % 12;
             pidgey = pidgey - tPidgey;
             pidgeotto = pidgeotto - tPidgeotto;
             candy = x - pidgey;
          }
          else
          {
             tPidgeotto = 12-(x - pidgey - candy) % 12;
             pidgey = pidgey - tPidgey;
             pidgeotto = pidgeotto - tPidgeotto;
             candy = x - pidgey - pidgeotto;
          }
        }
       }
      //if the player doesn't have any pidgeotto then this determines how many pidgey to transfer.
      else
      { 
        tPidgey = (x - pidgeotto) % 12;
        pidgey = tPidgey;
        candy = x - tPidgey - tPidgeotto;
      }
      //checks if the amount of evolutions exceeds the total pidgey
      while (candy/12 > pidgey)
      {
        //adds 12 pidgey back and takes away 12 candies unless doing so exceeds the original
        //pidgey count.
        if (pidgey + 12 <= startPidgey)
        {
          pidgey = pidgey + 12;
          candy = candy -12;
        }
        else
        {
          tempCandy = (x - startPidgey)%12;
          candy = x - startPidgey - tempCandy;
          pidgey = startPidgey;
        }
      }
      System.out.println("Transfer: " + (startPidgey - pidgey) + " pidgey, and " + (startPidgeotto - pidgeotto) + 
                         " Pidgeotto. Resulting in: " + (candy + tempCandy) + " candies, " + pidgey + " pidgey, and "
                           + pidgeotto + " pidgeotto.");
 
      evolves = candy / 12;
      pidgeotto = pidgeotto + evolves;
      
      //calculates candy and pidgey after evolutions
      candy = candy - 11*evolves + tempCandy;
      pidgey = pidgey - evolves;
      xp = xp + evolves * 500;
      tPidgey = 0;
      tPidgeotto = 0;
       x = candy + pidgey + pidgeotto;
      System.out.println("Evolve " + evolves + " pidgey.");
      System.out.println("Resulting in: " + candy + " candies, " + pidgey + " pidgey, and " + pidgeotto +
                         " pidgeotto.");
      System.out.println("Total xp: " + xp);
      }
  }
}