import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrades {
public static void main(String[] args) {
Scanner scanner = new Scanner([System.in](http://system.in/));
ArrayList<Integer> grades = new ArrayList<>();
int choice;

```
    System.out.println("Welcome to the Grade Management System!");

    // Loop to input grades
    do {
        System.out.print("Enter the student's grade (0-100): ");
        int grade = scanner.nextInt();

        // Validate grade input
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
            System.out.println("Grade added successfully.");
        } else {
            System.out.println("Invalid grade. Please enter a number between 0 and 100.");
        }

        System.out.print("Do you want to enter another grade? (1 for Yes, 0 for No): ");
        choice = scanner.nextInt();
    } while (choice == 1);

    // Check if there are grades to process
    if (grades.size() > 0) {
        int highest = findHighest(grades);
        int lowest = findLowest(grades);
        double average = calculateAverage(grades);

        System.out.println("\\nGrade Summary:");
        System.out.println("Total Students: " + grades.size());
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
    } else {
        System.out.println("No grades entered. Exiting program.");
    }

    scanner.close();
}

// Method to calculate the average
public static double calculateAverage(ArrayList<Integer> grades) {
    int sum = 0;
    for (int grade : grades) {
        sum += grade;
    }
    return (double) sum / grades.size();
}

// Method to find the highest grade
public static int findHighest(ArrayList<Integer> grades) {
    int highest = grades.get(0);
    for (int grade : grades) {
        if (grade > highest) {
            highest = grade;
        }
    }
    return highest;
}

// Method to find the lowest grade
public static int findLowest(ArrayList<Integer> grades) {
    int lowest = grades.get(0);
    for (int grade : grades) {
        if (grade < lowest) {
            lowest = grade;
        }
    }
    return lowest;
}

```}