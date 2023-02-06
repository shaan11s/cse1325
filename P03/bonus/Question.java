public class Question {
    //attributes or fields
    private static int nextQuestionNumber = 1;
    private final int questionNumber;
    private String question;
    private String[] answers;
    private int rightAnswer;

    //methods (public)
    public Question(String question, String[] answers, int rightAnswer){
        this.question = question;
        this.answers = answers;

    //count the number of strings in the string array
        int lengthOfAnswers = answers.length;

        if(rightAnswer < 0 || rightAnswer > lengthOfAnswers){
            throw new IllegalArgumentException("Right answer value is ILLEGAL\n");
        }
        this.rightAnswer = rightAnswer;
        this.questionNumber = nextQuestionNumber++;
    }

    public boolean checkAnswer(int answer){

        if (answer == this.rightAnswer){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(questionNumber + " " +  question + "\n");
        for(String a: answers){
            str.append(a + "\n");
        }

        return str.toString();
    }
}

