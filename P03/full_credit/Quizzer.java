import java.util.Scanner;

public class Quizzer {
    public static void main(String[] args){
    Scanner myScanner = new Scanner(System.in);

            try{
                Quiz quiz1 = new Quiz();
                 double grade = quiz1.takeQuiz();
                 grade *= 100;
                 System.out.printf("Grade is %f", grade);
                 myScanner.close();
                 
            }
            catch(IllegalArgumentException i){
                System.err.println("value must be greater than one and lower than number of questions.");
            }


    }
}
