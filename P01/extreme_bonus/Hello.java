//EXTREMEEE

//(OLD)import java.util.Scanner; 
 
public class Hello
{
    public static void main(String args[])
    {
        //initialize variables
        int min = 1000;
        int max = 9999;

        //generate random value
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);

        //create the scanner object
        //Scanner myObj = new Scanner(System.in);
        //(OLD)System.out.println("What is your name?");

        //(OLD)String Name = myObj.nextLine();
        System.out.println("Hello user #" + random_int);

    }
}