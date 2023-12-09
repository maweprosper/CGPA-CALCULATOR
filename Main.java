import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();

        String[] courseNamesAndCode = new String[numCourses];
        int[] creditUnits = new int[numCourses];
        int[] scores = new int[numCourses];
        char[] letterGrades = new char[numCourses];
        int[] numberGrades = new int[numCourses];
        String[] remarks = new String[numCourses];

        // Input course details
        for (int i = 0; i < numCourses; i++) {
            System.out.println("\nCourse " + (i + 1) + ":");

            System.out.print("Enter the course name: ");
            courseNamesAndCode[i] = scanner.nextLine(); 

            System.out.print("Enter the course unit: ");
            creditUnits[i] = scanner.nextInt();

            System.out.print("Enter the score: ");
            scores[i] = scanner.nextInt();
            scanner.nextLine();


            GradeCalculator.assignGrades(scores[i], i, letterGrades, numberGrades, remarks);
        }

        // Calculate GPA
        double totalCreditUnits = 0;
        double weightedGradePoints = 0;

        for (int i = 0; i < numCourses; i++) {
            totalCreditUnits += creditUnits[i];
            weightedGradePoints += creditUnits[i] * numberGrades[i];
        }

        double gpa = weightedGradePoints / totalCreditUnits;

        System.out.println("\n--------------------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-13s | %-6s | %-12s | %-20s |\n", "Course Name & Code", "Course Unit", "Grade", "Grade Unit", "Remark");
        System.out.println("--------------------------------------------------------------------------------------------");

        for (int i = 0; i < numCourses; i++) {
            System.out.printf("| %-30s | %-13d | %-6s | %-12d | %-20s |\n", courseNamesAndCode[i], creditUnits[i], letterGrades[i], numberGrades[i], remarks[i]);
        }

        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("| %-46s | %-12.2f |\n", "Total Credit Units", totalCreditUnits);
        System.out.printf("| %-46s | %-12.2f |\n", "Weighted Grade Points", weightedGradePoints);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("| %-46s | %-12.2f |\n", "GPA", gpa);
        System.out.println("--------------------------------------------------------------------------------------------");

        scanner.close();
    }
}

class GradeCalculator {
    static void assignGrades(int score, int index, char[] letterGrades, int[] numberGrades, String[] remarks) {
        if (score >= 70 && score <= 100) {
            letterGrades[index] = 'A';
            numberGrades[index] = 5;
            remarks[index] = "Excellent";
        } else if (score >= 60 && score <= 69) {
            letterGrades[index] = 'B';
            numberGrades[index] = 4;
            remarks[index] = "Very Good";
        } else if (score >= 50 && score <= 59) {
            letterGrades[index] = 'C';
            numberGrades[index] = 3;
            remarks[index] = "Good";
        } else if (score >= 45 && score <= 49) {
            letterGrades[index] = 'D';
            numberGrades[index] = 2;
            remarks[index] = "Fair";
        } else if (score >= 40 && score <= 44) {
            letterGrades[index] = 'E';
            numberGrades[index] = 1;
            remarks[index] = "Pass";
        } else {
            letterGrades[index] = 'F';
            numberGrades[index] = 0;
            remarks[index] = "Fail";
        }
    }
}
