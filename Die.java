import java.util.Scanner;

public class Die
{
    // Instance variables
    int sides;
    // Constructor
    public Die()
    {
        sides = 6;
    }
    public Die(int s)
    {
        sides = s;
    }
    // Methods
    public int roll()
    {
        int r = (int)(Math.random() * sides) + 1;
        return r;
    }
}
