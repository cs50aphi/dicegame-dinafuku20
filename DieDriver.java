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
        // have user pick a number of sides between 0 and 101
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
            // counting number of times dice is rolled
            rolls1++;
            // if p1Twice is true, player can roll twice
            if (p1Twice)
            {
                // if the player rolls a number that adds up to the goal
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
                    // have the player roll a second time
                    tempRollAgain = p1.roll();
                    System.out.println("Player 1 rolled a " + tempRoll + " and a " + tempRollAgain);
                    System.out.println();
                    location1 += tempRoll;
                    location1 += tempRollAgain;
                    rolls1++;
                    // if the player reaches the goal
                    if (location1 + tempRoll + tempRollAgain == goal)
                    {
                        // win
                        System.out.println("Player 1 rolled a " + tempRoll);
                        System.out.println("Player 1 wins with " + rolls1 + " rolls!");
                        p1Win = true;
                        gameOver = true;
                    }
                }
                // set twice to false, so player doesn't roll twice every round
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
                    // if 8 or 24 is rolled
                    if (tempRoll == 8 || tempRoll == 24)
                    {
                        System.out.println("Player 1 rolled a " + tempRoll);
                        System.out.println("Player 1 gets to roll twice next turn, since they rolled one of Kobe's numbers!");
                        System.out.println();
                        // if p1 has won, set gameOver to true;
                        location1 += tempRoll;
                        // player rolls twice next turn
                        p1Twice = true;
                    }
                    // just roll
                    else
                    {
                        System.out.println("Player 1 rolls a " + tempRoll);
                        System.out.println();
                        location1 += tempRoll;
                    }
                }
                // player exceeds goal so don't add
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
            // count rolls for p2
            rolls2++;
            // if players rolls twice this round
            if (p2Twice)
            {
                // if player reaches the goal
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
                    // roll again
                    tempRollAgain = p2.roll();
                    System.out.println("Player 2 rolled a " + tempRollTwo + " and a " + tempRollAgain);
                    System.out.println();
                    location2 += tempRollTwo;
                    location2 += tempRollAgain;
                    rolls2++;
                    // if player reaches the goal
                    if (location2 + tempRollTwo + tempRollAgain == goal)
                    {
                        System.out.println("Player 2 rolled a " + tempRollTwo);
                        System.out.println("Player 2 wins with " + rolls2 + " rolls!");
                        p2Win = true;
                        gameOver = true;
                    }
                }
                // player doesn't roll twice each round after so set p2Twice to false
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
                // if the player doesn't reach the goal yet
                if (location2 + tempRollTwo < goal)
                {
                    // if player rolls an 8 or 24
                    if (tempRollTwo == 8 || tempRollTwo == 24)
                    {
                        System.out.println("Player 2 rolled a " + tempRollTwo);
                        System.out.println("Player 2 gets to roll twice next turn, since they rolled one of Kobe's numbers!");
                        System.out.println();
                        // if p1 has won, set gameOver to true;
                        location2 += tempRollTwo;
                        // p2 rolls twice next round
                        p2Twice = true;
                    }
                    // just roll and add to location
                    else
                    {
                        System.out.println("Player 2 rolls a " + tempRollTwo);
                        System.out.println();
                        location2 += tempRollTwo;
                    }
                }
                // if player exceeds, don't add
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