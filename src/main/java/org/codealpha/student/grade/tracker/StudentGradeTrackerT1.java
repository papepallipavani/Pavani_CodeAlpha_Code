package org.codealpha.student.grade.tracker;

import org.codealpha.student.grade.tracker.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTrackerT1 {

    private ArrayList<Student> students;

    public StudentGradeTrackerT1() {
        students = new ArrayList<>();
    }

    public void addNewStudent(String name, double grade) {
        students.add(new Student(name, grade));
    }

    public double computeAverage() {
        if (students.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        return sum / students.size();
    }

    public Student findHighestGrade() {
        if (students.isEmpty()) {
            return null;
        }
        Student highest = students.get(0);
        for (Student student : students) {
            if (student.getGrade() > highest.getGrade()) {
                highest = student;
            }
        }
        return highest;
    }

    public Student findLowestGrade() {
        if (students.isEmpty()) {
            return null;
        }
        Student lowest = students.get(0);
        for (Student student : students) {
            if (student.getGrade() < lowest.getGrade()) {
                lowest = student;
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentGradeTrackerT1 gradeTrackerT1 = new StudentGradeTrackerT1();

        while (true) {
            System.out.println("Enter student name ( type 'done' to finish): ");

            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Enter student grade: ");

            String gradeInput =  scanner.nextLine();


            try {
                double grade = Double.parseDouble(gradeInput);
                gradeTrackerT1.addNewStudent(name, grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter a valid grade.");
            }

        }

        double average = gradeTrackerT1.computeAverage();
        Student highest = gradeTrackerT1.findHighestGrade();
        Student lowest = gradeTrackerT1.findLowestGrade();

        System.out.println("Average grade: " + average);
        if (highest != null) {
            System.out.println("Highest grade: " + highest.getGrade() + " (" + highest.getName() + ")");
        }
        if (lowest != null) {
            System.out.println("Lowest grade: " + lowest.getGrade() + " (" + lowest.getName() + ")");
        }

        scanner.close();

    }

}
