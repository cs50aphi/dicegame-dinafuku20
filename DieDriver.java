import java.util.Scanner;

public class DieDriver
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean gameOver = false;
        boolean p1Win = false;
        boolean p2Win = false;
        boolean p1Twice = false;
        boolean p2Twice = false;
        int tempRollAgain = 0;
        int goal = 100;
        int location1 = 0;
        int location2 = 0;
        int rolls1 = 0;
        int rolls2 = 0;
        // Players pick number of sides
        System.out.println("How many sides would you like on your dice?");
        int sides = in.nextInt();
        System.out.println();
        while (sides <= 0 || sides > 100)
        {
            System.out.println("Please pick a number between 0 and 101.");
            sides = in.nextInt();
        }
        System.out.println();
        // Create players p1 and p2
        Die p1 = new Die(sides);
        Die p2 = new Die(sides);
        // While gameOver is false
        while (!gameOver)
        {
            // Report player location
            System.out.println("Player 1 is at " + location1);
            pause();
            // roll for p1
            int tempRoll = p1.roll();
            rolls1++;
            if (p1Twice)
            {
                if (location1 + tempRoll == goal)
                {
                    System.out.println("Player 1 rolled a " + tempRoll);
                    System.out.println("Player 1 wins with " + rolls1 + " rolls!");
                    // if p1 has won, set gameOver to true;
                    location1 += tempRoll;
                    p1Win = true;
                    gameOver = true;
                }
                else
                {
                    tempRollAgain = p1.roll();
                    System.out.println("Player 1 rolled a " + tempRoll + " and a " + tempRollAgain);
                    System.out.println();
                    location1 += tempRoll;
                    location1 += tempRollAgain;
                    rolls1++;
                    if (location1 + tempRoll + tempRollAgain == goal)
                    {
                        System.out.println("Player 1 rolled a " + tempRoll);
                        System.out.println("Player 1 wins with " + rolls1 + " rolls!");
                        p1Win = true;
                        gameOver = true;
                    }
                }
                p1Twice = false;
            }
            else
            {
                // check to see if p1 has won
                if (location1 + tempRoll == goal)
                {
                    System.out.println("Player 1 rolled a " + tempRoll);
                    System.out.println("Player 1 wins with " + rolls1 + " rolls!");
                    // if p1 has won, set gameOver to true;
                    location1 += tempRoll;
                    p1Win = true;
                    gameOver = true;
                }
                // if not game over
                if (location1 + tempRoll < goal)
                {
                    if (tempRoll == 8 || tempRoll == 24)
                    {
                        System.out.println("Player 1 rolled a " + tempRoll);
                        System.out.println("Player 1 gets to roll twice next turn, since they rolled one of Kobe's numbers!");
                        System.out.println();
                        // if p1 has won, set gameOver to true;
                        location1 += tempRoll;
                        p1Twice = true;
                    }
                    else
                    {
                        System.out.println("Player 1 rolls a " + tempRoll);
                        System.out.println();
                        location1 += tempRoll;
                    }
                }
                else
                {
                    System.out.println("Player 1 rolled a " + tempRoll + " and exceeds the goal, so it doesn't count!");
                    System.out.println();
                }
            }
            // Report p2 location
            System.out.println("Player 2 is at " + location2);
            pause();
            // roll for p2
            int tempRollTwo = p2.roll();
            rolls2++;
            if (p2Twice)
            {
                if (location2 + tempRollTwo == goal)
                {
                    System.out.println("Player 2 rolled a " + tempRollTwo);
                    System.out.println("Player 2 wins with " + rolls2 + " rolls!");
                    // if p2 has won, set gameOver to true;
                    location2 += tempRollTwo;
                    p2Win = true;
                    gameOver = true;
                }
                else
                {
                    tempRollAgain = p2.roll();
                    System.out.println("Player 2 rolled a " + tempRollTwo + " and a " + tempRollAgain);
                    System.out.println();
                    location2 += tempRollTwo;
                    location2 += tempRollAgain;
                    rolls2++;
                    if (location2 + tempRollTwo + tempRollAgain == goal)
                    {
                        System.out.println("Player 2 rolled a " + tempRollTwo);
                        System.out.println("Player 2 wins with " + rolls2 + " rolls!");
                        p2Win = true;
                        gameOver = true;
                    }
                }
                p2Twice = false;
            }
            else
            {
                // check to see if p2 has won
                if (location2 + tempRollTwo == goal)
                {
                    System.out.println("Player 2 rolled a " + tempRollTwo);
                    System.out.println("Player 2 wins with " + rolls2 + " rolls!");
                    // if p2 has won, set gameOver to true;
                    location2 += tempRollTwo;
                    p2Win = true;
                    gameOver = true;
                }
                if (location2 + tempRollTwo < goal)
                {
                    if (tempRollTwo == 8 || tempRollTwo == 24)
                    {
                        System.out.println("Player 2 rolled a " + tempRollTwo);
                        System.out.println("Player 2 gets to roll twice next turn, since they rolled one of Kobe's numbers!");
                        System.out.println();
                        // if p1 has won, set gameOver to true;
                        location2 += tempRollTwo;
                        p2Twice = true;
                    }
                    else
                    {
                        System.out.println("Player 2 rolls a " + tempRollTwo);
                        System.out.println();
                        location2 += tempRollTwo;
                    }
                }
                else
                {
                    System.out.println("Player 2 rolled a " + tempRollTwo + " and exceeds the goal, so it doesn't count!");
                    System.out.println();
                }
            }
            // if both players win on the same turn, it's a tie
            if (p1Win && p2Win)
            {
                System.out.println("It's a tie!");
            }
        }
    }
    public static void pause()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Press enter to continue");
        in.nextLine();
    }
}