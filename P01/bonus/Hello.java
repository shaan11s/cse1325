

import java.util.Scanner; 
 
public class Hello
{
    public static void main(String args[])
    {
        //create the scanner object
        Scanner myObj = new Scanner(System.in);
        System.out.println("What is your name?");

        String Name = myObj.nextLine();
        System.out.println("Hello " + Name);

    }
}