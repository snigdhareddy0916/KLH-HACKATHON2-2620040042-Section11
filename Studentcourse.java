public class Studentcourse {
    import java.util.Scanner;

class Studentcourse {
    String studentName;
    String rollNumber;
    double marks;
    String courseName;
    int courseCredits;
    public Studentcourse(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }
    public boolean checkEligibility() {
        return this.marks >= 50;
    }

    public double calculateFee() {
        return this.courseCredits * 1500;
    }
    public double calculateScholarship() {
        double fee = calculateFee();
        if (this.marks >= 85) {
            return fee * 0.20;
        } else if (this.marks >= 70 && this.marks <= 84) {
            return fee * 0.10;
        } else {
            return 0.0;
        }
    }
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }
    public void displayDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility status: Eligible");
        System.out.println("Total Fee: Rs. " + calculateFee());
        System.out.println("Scholarship Amount: Rs. " + calculateScholarship());
        System.out.println("Final Fee: Rs. " + calculateFinalFee());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();
        Studentcourse student = new Studentcourse(studentName, rollNumber, marks, courseName, courseCredits);
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("Student " + student.studentName + " (Roll No: " + student.rollNumber + ") is NOT eligible for course registration due to insufficient marks.");
        }
    }
}
    
}
