import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        // Define the questions and correct answers
        String[] questions = {
                "What is the capital of France?",
                "Which planet is known as the Red Planet?",
                "Who wrote the play 'Hamlet'?",
                "What is the powerhouse of the cell?",
                "What is the largest mammal in the world?"
        };

        String[] options = {
                "A. Rome\tB. Paris\tC. Berlin\tD. Madrid",
                "A. Jupiter\tB. Mars\tC. Venus\tD. Saturn",
                "A. William Shakespeare\tB. Charles Dickens\tC. Jane Austen\tD. Mark Twain",
                "A. Nucleus\tB. Mitochondria\tC. Ribosome\tD. Chloroplast",
                "A. African elephant\tB. Blue whale\tC. Giraffe\tD. Hippopotamus"
        };

        char[] answers = { 'B', 'B', 'A', 'B', 'B' };

        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Quiz Game!");

        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            // Display the question and options
            System.out.println("\n" + questions[i]);
            System.out.println(options[i]);

            // Prompt the user for input
            System.out.print("Enter your answer (A, B, C, or D): ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            // Compare the user's answer with the correct answer
            if (userAnswer == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is " + answers[i]);
            }
        }

        // Calculate and display the score
        double percentage = (double) score / questions.length * 100;
        System.out.println("\nYour final score: " + score + "/" + questions.length + " (" + percentage + "%)");

        // Close the scanner
        scanner.close();
    }
}