/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Assignment10
*/
import java.io.*;
import java.util.Scanner;

public class Assignment10 {

    private static final String OUTPUT_FILE = "FinalGrades.txt";
    private static final String ERROR_FILE = "ErrorGrades.txt";
    private static final int NO_OF_QUIZZES = 10;
    private static final int NO_OF_EXAMS = 3;
    private static final double PERCENTAGE_QUIZZES = 25;
    private static final double PERCENTAGE_EXAM_1 = 25;
    private static final double PERCENTAGE_EXAM_2 = 25;
    private static final double PERCENTAGE_FINAL_EXAM = 25;

    private static double getQuizPercentage(double[] quizScores) {

        double lowScore = 0;
        double sum = 0;
        for (int index = 0; index < quizScores.length; index++) {
            if (index == 0 || lowScore > quizScores[index]) {
                lowScore = quizScores[index];
            }
            sum += quizScores[index];
        }
        sum -= lowScore;

        double avg = sum / (quizScores.length - 1);
        double percentage = avg * PERCENTAGE_QUIZZES / 100;
        return percentage;
    }

    private static double getExamPercentage(double[] examScores) {
        double exam1Score = examScores[0];
        double exam2Score = examScores[1];
        double finalExamScore = examScores[2];

        if (exam1Score != -1 && exam1Score < exam2Score && exam1Score < finalExamScore) {
            exam1Score = finalExamScore;
        } else if (exam2Score != -1 && exam2Score < exam1Score && exam2Score < finalExamScore) {
            exam2Score = finalExamScore;
        }

        double exm1Percentage = 0, exm2Percentage = 0, finalExamPercentage = 0;
        if (exm1Percentage != -1) {
            exm1Percentage = exam1Score * PERCENTAGE_EXAM_1 / 100;
        }
        if (exm2Percentage != -1) {
            exm2Percentage = exam2Score * PERCENTAGE_EXAM_2 / 100;
        }
        if (exm1Percentage != -1) {
            finalExamPercentage = finalExamScore * PERCENTAGE_FINAL_EXAM / 100;
        }

        return exm1Percentage + exm2Percentage + finalExamPercentage;
    }

    private static char getLetterGrade(double finalPercentage) {
        if (finalPercentage >= 89.5) {
            return 'A';
        } else if (finalPercentage >= 79.5) {
            return 'B';
        } else if (finalPercentage >= 69.5) {
            return 'C';
        } else if (finalPercentage >= 59.5) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        File file = new File("RawGradesFile.txt");

        BufferedReader bufferReader = null;
        BufferedWriter bufferOutputWriter = null;
        BufferedWriter bwErrorWriter = null;
        String line = "";

        try {
            bufferReader = new BufferedReader(new FileReader(file));
            bufferOutputWriter= new BufferedWriter(new FileWriter(OUTPUT_FILE));
            bwErrorWriter = new BufferedWriter(new FileWriter(ERROR_FILE));

            while ((line = bufferReader.readLine()) != null) {

                String[] tokens = line.split(",");
                if (tokens[1] == null || tokens[1].trim() == "") {
                    bwErrorWriter.write(line + "\n");
                } else {
                    double[] quizzes = new double[NO_OF_QUIZZES];
                    double[] exams = new double[NO_OF_EXAMS];

                    for (int index = 2; index < 2 + NO_OF_QUIZZES; index++) {
                        if (tokens[index] == null || tokens[index].trim() == "") {
                            quizzes[index - 2] = 0;
                        } else {
                            quizzes[index - 2] = Double.parseDouble(tokens[index]);
                        }
                    }

                    for (int index = 12; index < 12 + NO_OF_EXAMS; index++) {
                        if (tokens[index] == null || tokens[index].trim() == "") {
                            exams[index - 12] = 0;
                        } else {
                            exams[index - 12] = Double.parseDouble(tokens[index]);
                        }
                    }

                    double totalPercentage = getQuizPercentage(quizzes) + getExamPercentage(exams);
                    char letterGrade = getLetterGrade(totalPercentage);

                    bufferOutputWriter.write(tokens[0] + " " + tokens[1] + " " + totalPercentage + " " + letterGrade + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getClass().getCanonicalName() + ": Cound not find file");
        } catch (IOException e) {
            System.out.println("Error: " + e.getClass().getCanonicalName() + ": reading or writing file");
        } catch (NumberFormatException e) {
            System.out.println(
                    "Error: " + e.getClass().getCanonicalName() + ": Input string was not in correct format...");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(
                    "Error: " + e.getClass().getCanonicalName() + ": Index was outside the bounds of the array...");
        } finally {
            try {
                if (bufferReader != null)
                    bufferReader.close();
            } catch (IOException e) {
            }

            try {
                if (bufferOutputWriter != null) {
                    bufferOutputWriter.close();
                }
            } catch (IOException e) {

            }

            try {
                if (bwErrorWriter != null) {
                    bwErrorWriter.close();
                }
            } catch (IOException e) {

            }
        }
    }
}
