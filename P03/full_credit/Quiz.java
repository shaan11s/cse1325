import java.util.Scanner;

public class Quiz{
//fields
private Question[] questions;

public Quiz(){
loadQuiz();
}
public double takeQuiz(){

    Scanner myScanner = new Scanner(System.in);
    int correctAnswers = 0;

    for(Question m : questions) {
        System.out.println(m);
         //ask for proposedAnswer (int) 
        int tempAnswer = myScanner.nextInt();
        //pass proposedAnswer to m.checkAnswer
        if(m.checkAnswer(tempAnswer)){
            correctAnswers++;
        }
    }
    double grade = correctAnswers/questions.length;
    myScanner.close();
    return grade;
 
}

private void loadQuiz(){

    String answersOne[] = new String[4]; 
        answersOne[0] = "Java programming ";
        answersOne[1] = "data validation ";
        answersOne[2] = "defensive typing ";
        answersOne[3] = "common sense";

    Question one = new Question("Ensuring that a program operates on clean, correct and useful data is called " ,answersOne , 1);
    questions[0] = one;

    String answersTwo[] = new String[4]; 
        answersTwo[0] = "a program that automatically refactors our code ";
        answersTwo[1] = "another main program than tests the correctness of a class or system";
        answersTwo[2] = "an inadequate test ";
        answersTwo[3] = "a test of git's ability to checkout earlier commits ";

    Question two = new Question("A regression test is" ,answersTwo , 1);
    questions[1] = two;

    String answersThree[] = new String[4]; 
        answersThree[0] = "exactly one try and exactly one catch block ";
        answersThree[1] = "one try block and zero or more catch blocks ";
        answersThree[2] = "one try, one or more catch, and an optional finally block ";
        answersThree[3] = "one or more try blocks, one or more catch blocks, and exactly one finally block";

    Question three = new Question("A try / catch clause may include ?" ,answersThree , 2);
    questions[2] = three;

    String answersFour[] = new String[4]; 
        answersFour[0] = "outputs formatted data ";
        answersFour[1] = "is an expression that doesn't throw exceptions ";
        answersFour[2] = "is selected from a book of problem-free expressions, similar to chess 'book openings'";
        answersFour[3] = "defines the 'look' of valid text data such that it is easily verified in code ";

    Question four = new Question("A 'regular expression' is" ,answersFour , 3);
    questions[3] = four;

    String answersFive[] = new String[4]; 
    answersFive[0] = "printing an error message to System.err ";
    answersFive[1] = "reading a new-line";
    answersFive[2] = "a print statement";
    answersFive[3] = "continuing without logging an error";

    Question five = new Question("Options for reporting errors include" ,answersFive , 0);
    questions[4] = five;

    String answersSix[] = new String[4]; 
    answersSix[0] = "AC MILAN";
    answersSix[1] = "JUVENTUS";
    answersSix[2] = "ROMA";
    answersSix[3] = "NAPOLI";

    Question six = new Question("Which team is the best team in Serie A?" ,answersSix , 0);
    questions[5] = six;
}

}

