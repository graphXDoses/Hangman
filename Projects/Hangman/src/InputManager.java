import java.util.Scanner;

public class InputManager
{
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static String lastUserInput = null;

    public static void read()
    {
        lastUserInput = USER_INPUT.nextLine();
    }

    public static String getLastUserInput()
    {
        return(lastUserInput);
    }
}
