/*
 This program is a simple console-based quiz game in Java.

 How it works:
 1. The program defines a list of multiple-choice questions, 
    each with four possible answers (labeled A, B, C, D) 
    and one correct choice.
 
 2. The user is asked each question in turn. 
    They must type the letter (A, B, C, or D) that corresponds to their answer.

 3. For each correct answer, the user earns 1 point. 
    Incorrect answers earn 0 points.

 4. At the end of the quiz, the program:
    - Calculates the percentage score (correct answers / total questions × 100).
    - Displays the percentage.
    - Displays the total score out of the number of questions.

 Code structure:
 - Main class:
    * Creates a Scanner for user input.
    * Initializes the list of Question objects (the quiz).
    * Loops through all questions, displays them, takes input, and checks correctness.
    * Calculates and prints the final results.
    * Closes the Scanner.
 
 - Question class:
    * Stores the question text, correct answer, and answer choices.
    * display(): Prints the question with labeled choices (A–D).
    * isCorrect(): Checks if the user’s answer matches the correct choice, 
      returns 1 if correct, 0 if not.

 This program demonstrates basic Java concepts such as:
    - Classes and objects
    - Arrays
    - Loops
    - User input with Scanner
    - Simple conditional logic

Challenges I faced:
    - I have alot of experience with javascript but not a strongly typed language
    - Java is much more rigid than javascript so I needed to be more "verbose"
    - I am used to functional programming and not OOP so it was alittle difficult
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create scanner for user input

        int score = 0; // keeps track of correct answers

        // array of question objects with text, correct option, and answer choices
        Question[] questions = {
            new Question("What is 2 + 2", 'B', new String[] {"3", "4", "5", "2"}),
            new Question("what is 4 x 3", 'B', new String[] {"8", "12", "9", "3"}),
            new Question("What is 9 - 3", 'C', new String[] {"5", "8", "6", "2"}),
            new Question("What is 45 / 5", 'A', new String[] {"9", "4", "3", "7"}),
            new Question("What is 4 + 6", 'D', new String[] {"4", "8", "9", "10"})
        };
    
        char input; // stores user input choice

        // loop through all questions
        for (int i = 0; i < questions.length; i++){
            // show question and options
            questions[i].display();
            // read first character of input
            input = scanner.nextLine().charAt(0);
            // increase score if correct
            score += questions[i].isCorrect(input);
        }

        // calculate percentage score
        // I had to put double inside the brackets to do decimal division
        double percentage = ((double) score / questions.length) * 100;
        System.out.println("Your score percentage was: " + percentage + "%");

        // display final score
        System.out.println("Your Scored " + score + " out of " + questions.length);
        
        scanner.close();
    }
}

// Question object template
class Question {

    String questionText;   
    char correctChoice;
    String[] choices;

    // constructor to set question, correct choice, and options
    public Question(String questionText, char correctChoice, String[] choices ) {
        this.questionText = questionText;
        this.correctChoice = correctChoice;
        this.choices = choices;
    }

    // method to display question and choices
    public void display() {
        char letter = 'A'; // start from A for choices
        System.out.println(questionText + " ?");

        // loop through options and display with A, B, C, D labels
        for (int i = 0; i < 4; i++) {
            System.out.println(letter + ": " + choices[i]);
            letter++;
        }
        
        System.out.print("Enter your choice: ");
    }

    // method to check if user input is correct
    public int isCorrect(char input) {
        if (input == correctChoice) {
            return 1; // return 1 if correct
        } else {
            return 0; // return 0 if wrong
        }
    }
}
