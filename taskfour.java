import java.util.*;
import java.util.Timer;
public class taskfour {
        private static final int TIME_PER_QUESTION = 15; // Seconds

        private List<Question> questions;
        private int score;
        private Scanner scanner;

        public taskfour() {
            questions = new ArrayList<>();
            score = 0;
            scanner = new Scanner(System.in);

            // Initialize quiz questions (you can add more)
            questions.add(new Question("What is the capital of France?", "Berlin", "Paris", "Madrid", "Rome", "Paris"));
            questions.add(new Question("Which planet is known as the 'Red Planet'?", "Jupiter", "Mars", "Venus", "Saturn", "Mars"));
            questions.add(new Question("What is the largest mammal in the world?", "African Elephant", "Blue Whale", "Polar Bear", "Giraffe", "Blue Whale"));
            // ... add more questions
        }

        public void startQuiz() {
            for (int i = 0; i < questions.size(); i++) {
                Question question = questions.get(i);
                System.out.println("\nQuestion " + (i + 1) + ": " + question.getQuestion());
                question.displayOptions();

                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("\nTime's up!");
                        handleAnswer(question, ' '); // Treat no answer as incorrect
                    }
                };

                timer.schedule(task, TIME_PER_QUESTION * 1000L); // Schedule timer

                char userAnswer = getAnswerFromUser();

                timer.cancel(); // Cancel timer if the user answered in time
                handleAnswer(question, userAnswer);

            }

            displayResult();
            scanner.close();
        }

        private char getAnswerFromUser() {
            System.out.print("Enter your answer (A, B, C, or D): ");
            String input = scanner.nextLine().toUpperCase(); // Handle lowercase too
            if (input.length() > 0) {
                return input.charAt(0);
            } else {
                return ' '; // Handle empty input
            }
        }

        private void handleAnswer(Question question, char userAnswer) {
            char correctAnswer = question.getCorrectAnswer();
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else if (userAnswer != ' '){ // Do not print if time is up
                System.out.println("Incorrect. The correct answer is " + correctAnswer + ".");
            }
        }

        private void displayResult() {
            System.out.println("\nQuiz Finished!");
            System.out.println("Your final score: " + score + " out of " + questions.size());
        }

        public static void main(String[] args) {
            taskfour game = new taskfour();
            game.startQuiz();
        }
    }

    class Question {
        private String question;
        private String optionA, optionB, optionC, optionD;
        private char correctAnswer;

        public Question(String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
            this.question = question;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.correctAnswer = correctAnswer.toUpperCase().charAt(0); // Store as uppercase char
        }

        public String getQuestion() {
            return question;
        }

        public char getCorrectAnswer() {
            return correctAnswer;
        }


        public void displayOptions() {
            System.out.println("A. " + optionA);
            System.out.println("B. " + optionB);
            System.out.println("C. " + optionC);
            System.out.println("D. " + optionD);
        }
    }

