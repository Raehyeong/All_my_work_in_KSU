/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Lab3
*/

import java.util.ArrayList;
import java.util.Scanner;

class Question{
    private String question;
    private String answer;
    private int difficulty;

    public Question(){
        question = "";
        answer = "";
        difficulty = 1;
    }

    public Question(String q, String a, int d){
        question = q;
        answer = a;
        difficulty = d;
    }

    public String getQuestion() {
        return this.question;
    }
    public String getAnswer() {
        return this.answer;
    }
    public int getDifficulty() {
        return this.difficulty;
    }

    public void setAns(String answer) {
        this.answer = answer;
    }
    public void setQues(String ques) {
        this.question = ques;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

}

class Quiz{

    private ArrayList<Question> questions;
    public Quiz(){
        questions = new ArrayList<Question>();
    }

    void add_question(){

        Scanner scan = new Scanner(System.in);
        String question;
        String answer;
        int difficulty;

        System.out.println("What is the question Text?");
        question = scan.nextLine();
        System.out.println("What is the answer?");
        answer = scan.nextLine();
        System.out.println("How Difficult (1-3)?");
        difficulty = scan.nextInt();

        questions.add(new Question(question, answer, difficulty));

    }


    void modify_question(){
        Scanner scan = new Scanner(System.in);


        System.out.println("Choose the question to modify?");
        for(int i=0;i<questions.size();i++){
            System.out.println(i+". "+questions.get(i).getQuestion());
        }

        int menu = scan.nextInt();
        if(menu>=questions.size()){
            System.out.println("Not a valid choice.");
            return;
        }
        scan.nextLine();

        String ques, ans;
        int difficulty;
        System.out.println("What is the question Text?");
        ques = scan.nextLine();
        System.out.println("What is the answer?");
        ans = scan.nextLine();
        System.out.println("How Difficult (1-3)?");
        difficulty = scan.nextInt();


        questions.get(menu).setQues(ques);
        questions.get(menu).setAns(ans);
        questions.get(menu).setDifficulty(difficulty);

        scan.nextLine();

    }

    void remove_question(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose the question to remove?");
        for(int i=0;i<questions.size();i++){
            System.out.println(i+". "+questions.get(i).getQuestion());
        }

        int index = sc.nextInt();
        if(index>=questions.size()){
            System.out.println("Invalid Choice Entered");
            return;
        }

        questions.remove(index);

    }


    void give_quiz(){
        Scanner sc = new Scanner(System.in);
        String answer;
        int count = 0;

        for(int i=0;i<questions.size();i++){
            System.out.println(questions.get(i).getQuestion());
            answer = sc.nextLine();
            if(answer.equals(questions.get(i).getAnswer())){
                System.out.println("Correct");
                count++;
            }else{
                System.out.println("Incorrect");
            }
        }
        System.out.println("You got "+count+" out of "+questions.size());

    }
}

public class Lab3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int choice=-1;

        Quiz quiz = new Quiz();

        while(true){

            System.out.println("What would you like to do?");
            System.out.println("1. Add a question to the quiz");
            System.out.println("2. Remove a question from the quiz");
            System.out.println("3. Modify a question in the quiz");
            System.out.println("4. Take the quiz");
            System.out.println("5. Quit");

            choice = scan.nextInt();
            scan.nextLine();

            if(choice==1){
                quiz.add_question();
            }else if(choice==2){
                quiz.remove_question();
            }else if(choice==3){
                quiz.modify_question();
            }else if(choice==4){
                quiz.give_quiz();
            }else if(choice==5){
                break;
            }else{
                System.out.println("Invalid Choice Entered");
            }
        }
    }
}