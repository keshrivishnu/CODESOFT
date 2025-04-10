import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tasktwo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            List<Integer> marks = new ArrayList<>();
            for (int i = 1; i <= numSubjects; i++) {
                System.out.print("Enter marks for subject " + i + " (out of 100): ");
                int mark = scanner.nextInt();
                marks.add(mark);
            }

            int totalMarks = 0;
            for (int mark : marks) {
                totalMarks += mark;
            }

            double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("\nResults:");
            System.out.println("Total Marks: " + totalMarks);
            System.out.printf("Average Percentage: %.2f%%\n", averagePercentage); // Formatted output
            System.out.println("Grade: " + grade);

            scanner.close();
        }
    }

