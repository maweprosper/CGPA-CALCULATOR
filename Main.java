import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of courses
        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();

        // Initialize arrays to store course details
        String[] courseNamesAndCode = new String[numCourses];
        int[] creditUnits = new int[numCourses];
        int[] scores = new int[numCourses];
        char[] letterGrades = new char[numCourses];
        int[] numberGrades = new int[numCourses];

        // Input course details
        for (int i = 0; i < numCourses; i++) {
            System.out.println("\nCourse " + (i + 1) + ":");

            System.out.print("Enter the course name: ");
            courseNamesAndCode[i] = scanner.next();

            System.out.print("Enter the course unit: ");
            creditUnits[i] = scanner.nextInt();

            System.out.print("Enter the score: ");
            scores[i] = scanner.nextInt();

            // Assign letter and grade unit based on score
            assignGrades(scores[i], i, letterGrades, numberGrades);
        }

        // Calculate GPA
        double totalCreditUnits = 0;
        double weightedGradePoints = 0;

        for (int i = 0; i < numCourses; i++) {
            totalCreditUnits += creditUnits[i];
            weightedGradePoints += creditUnits[i] * numberGrades[i];
        }

        double gpa = weightedGradePoints / totalCreditUnits;

        // Display the result in a tabular form
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf("| %-30s | %-13s | %-6s | %-12s |\n", "Course Name & Code", "Course Unit", "Grade", "Grade Unit");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < numCourses; i++) {
            System.out.printf("| %-30s | %-13d | %-6s | %-12d |\n", courseNamesAndCode[i], creditUnits[i], letterGrades[i], numberGrades[i]);
        }

        System.out.println("------------------------------------------------------------------");
        System.out.printf("| %-46s | %-12.2f |\n", "Total Credit Units", totalCreditUnits);
        System.out.printf("| %-46s | %-12.2f |\n", "Weighted Grade Points", weightedGradePoints);
        System.out.println("------------------------------------------------------------------");
        System.out.printf("| %-46s | %-12.2f |\n", "GPA", gpa);
        System.out.println("------------------------------------------------------------------");

        // Close the scanner
        scanner.close();
    }

    // Helper method to assign letter and number grade based on score
    private static void assignGrades(int score, int index, char[] letterGrades, int[] numberGrades) {
        if (score >= 70 && score <= 100) {
            letterGrades[index] = 'A';
            numberGrades[index] = 5;
        } else if (score >= 60 && score <= 69) {
            letterGrades[index] = 'B';
            numberGrades[index] = 4;
        } else if (score >= 50 && score <= 59) {
            letterGrades[index] = 'C';
            numberGrades[index] = 3;
        } else if (score >= 45 && score <= 49) {
            letterGrades[index] = 'D';
            numberGrades[index] = 2;
        } else if (score >= 40 && score <= 44) {
            letterGrades[index] = 'E';
            numberGrades[index] = 1;
        } else {
            letterGrades[index] = 'F';
            numberGrades[index] = 0;
        }


    }
}